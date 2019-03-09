package org.kablambda.ois.proxy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import org.kablambda.ois.api.BooleanFunction;
import org.kablambda.ois.api.NumericalCommand;
import org.kablambda.ois.api.ShipCommand;

public class OisProxy {
    public static void main(String... args) {
        final Map<ShipCommand, Integer> shipCommandMapping = new ConcurrentHashMap<>();

        final OisClient client = new OisClient("/dev/ttys007", new OisClient.OisEventListener() {
            ChannelMapping<BooleanFunction, Boolean> booleanFunctionMapping = new ChannelMapping<>(s -> s.equals("1"));
            ChannelMapping<NumericalCommand, Double> numericalFunctionMapping = new ChannelMapping<>(Double::parseDouble);

            private boolean handshakeDone = false;

            @Override
            public void onHandshakeComplete(OisClient client) {
                System.out.println("Handshake");
                if (!handshakeDone) {
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
                    client.send("ACT");
                    handshakeDone = true;
                }
            }

            @Override
            public void onEvent(OisClient client, String event) {
                String[] parts = event.split("=");
                if (parts.length == 2) {
                    Integer channel = null;
                    try {
                        channel = Integer.parseInt(parts[0]);
                    } catch (NumberFormatException e) {
                        System.out.println("Unexpected event format '" + event + "'");
                    }
                    if (channel != null) {
                        Optional<?> f = booleanFunctionMapping.setValue(channel, parts[1]);
                        if (!f.isPresent()) {
                            f = numericalFunctionMapping.setValue(channel, parts[1]);
                        }
                        //f.ifPresent(o -> System.out.println(o.toString() + " set to " + parts[1]));
                    }
                } else {
                    System.out.println("Unrecognised input:" + event);
                }
            }
        });
        new Thread(new Runnable() {
            @Override
            public void run() {
                BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
                for (; ; ) {
                    String s = null;
                    try {
                        s = in.readLine();
                        if (s == null) {
                            return;
                        }
                        try {
                            ShipCommand c = ShipCommand.valueOf(s);
                            Integer channel = shipCommandMapping.get(c);
                            if (channel != null) {
                                client.send("EXC=" + channel);
                            }
                        } catch (IllegalArgumentException e) {
                            System.out.println("Bad command name " + s);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
