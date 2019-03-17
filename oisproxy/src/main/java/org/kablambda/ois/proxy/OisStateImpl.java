package org.kablambda.ois.proxy;

import org.kablambda.ois.api.BooleanFunction;
import org.kablambda.ois.api.NumericalCommand;
import org.kablambda.ois.api.ShipCommand;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class OisStateImpl implements OisState {
    private final OisClient client;
    private final ChannelMapping<BooleanFunction, Boolean> booleanFunctionMapping =
            new ChannelMapping<>(s -> s.equals("1"), BooleanFunctionChanged::new);
    private final ChannelMapping<NumericalCommand, Double> numericalFunctionMapping =
            new ChannelMapping<>(Double::parseDouble, NumericalCommandChanged::new);
    private final Map<ShipCommand, Integer> shipCommandMapping = new ConcurrentHashMap<>();
    private final BlockingQueue<OisStateEvent> events = new LinkedBlockingQueue<>();
    private volatile boolean stopped = false;
    private final Thread thread;


    public OisStateImpl(OisClient client) {
        this.client = client;
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                boolean handshakeDone = false;
                client.send("451");
                for (; ; ) {
                    if (stopped) {
                        return;
                    }
                    try {
                        String event = client.getEvent();
                        if (event == null) {
                            // the client has been stopped
                            return;
                        } else if (!handshakeDone && event.equals("452")) {
                            initialiseChannels(client);
                            client.send("ACT");
                            handshakeDone = true;
                            events.put(new OnActive());
                        } else {
                            String[] parts = event.split("=");
                            if (parts.length == 2) {
                                Integer channel = null;
                                try {
                                    channel = Integer.parseInt(parts[0]);
                                } catch (NumberFormatException e) {
                                    System.out.println("Unexpected event format '" + event + "'");
                                }
                                if (channel != null) {
                                    Optional<OisStateEvent> f = booleanFunctionMapping.setValue(channel, parts[1]);
                                    if (!f.isPresent()) {
                                        f = numericalFunctionMapping.setValue(channel, parts[1]);
                                    }
                                    f.ifPresent(e -> {
                                        try {
                                            events.put(e);
                                        } catch (InterruptedException e1) {
                                        }
                                    });
                                }
                            } else {
                                System.out.println("Unrecognised input:" + event);
                            }
                        }
                    } catch (InterruptedException e) {

                    }
                }
            }

            private void initialiseChannels(OisClient client) {
                int channel = 1;

                for (BooleanFunction f : Arrays.copyOfRange(BooleanFunction.values(), 0, 331)) { //332-3 crashes
                    client.send("NIB=" + f.name() + "," + channel);
                    booleanFunctionMapping.setMapping(channel++, f);
                }
                for (NumericalCommand f : NumericalCommand.values()) {
                    client.send("NIF=" + f.name() + "," + channel);
                    numericalFunctionMapping.setMapping(channel++, f);
                }
                for (ShipCommand f : ShipCommand.values()) {
                    client.send("CMD=" + f.name() + "," + channel);
                    shipCommandMapping.put(f, channel++);
                }
            }
        });
        thread.start();
    }

    @Override
    public Optional<Boolean> get(BooleanFunction f) {
        return booleanFunctionMapping.getValue(f);
    }

    @Override
    public Optional<Double> get(NumericalCommand f) {
        return numericalFunctionMapping.getValue(f);
    }

    @Override
    public OisStateEvent getEvent() {
        for (;;) {
            if (stopped) {
                return null;
            }
            try {
                OisStateEvent event = events.poll(1, TimeUnit.SECONDS);
                if (event != null) {
                    return event;
                }
            } catch (InterruptedException e) {
                //ignore
            }
        }
    }

    @Override
    public void send(ShipCommand command) {
        Integer channel = shipCommandMapping.get(command);
        if (channel != null) {
            client.send("EXC=" + channel);
        }
    }

    @Override
    public void stop() {
        client.stop();
        stopped = true;
        thread.interrupt();
    }
}
