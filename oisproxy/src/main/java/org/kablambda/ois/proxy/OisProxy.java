package org.kablambda.ois.proxy;

import org.kablambda.ois.api.ShipCommand;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OisProxy {
    public static void main(String... args) {

        final OisClient client = new OisClientImpl("/dev/ttys007");
        final OisState state = new OisStateImpl(client);
        new Thread(() -> {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            for (; ; ) {
                String s;
                try {
                    s = in.readLine();
                    if (s == null) {
                        return;
                    }
                    try {
                        ShipCommand c = ShipCommand.valueOf(s);
                        state.send(c);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Bad command name " + s);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(() -> {
            for (;;) {
                try {
                    state.getEvent().accept(new OisState.OisStateEventVisitor<Void>() {
                        @Override
                        public Void onBooleanFunctionChanged(OisState.BooleanFunctionChanged event) {
                            System.out.println(event.getBooleanFunction().getDescription() + " changed to " + event.getNewValue());
                            return null;
                        }

                        @Override
                        public Void onNumericalCommandChanged(OisState.NumericalCommandChanged event) {
                            System.out.println(event.getNumericalCommand().getDescription() + " changed to " + event.getNewValue());
                            return null;
                        }

                        @Override
                        public Void onActive() {
                            System.out.println("Interface is Active");
                            return null;
                        }
                    });
                } catch (InterruptedException e) {

                }
            }
        });
    }
}
