package org.kablambda.ois.proxy;

import org.kablambda.ois.api.BooleanFunction;
import org.kablambda.ois.api.ShipCommand;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class OisProxy {
    public static void main(String... args) throws FileNotFoundException {

        final OisClient client = new OisClientImpl("/dev/ttys007");
        final OisState state = new OisStateImpl(client);
        final List<UiController> uiControllers = new ArrayList<>();
        final UiControllerHost host = new UiControllerHost(state, uiControllers);

        uiControllers.add(new UiController() {
            int count = 0;
            @Override
            public void onStateEvent(OisState.OisStateEvent event, final OisState state) {
                event.accept(new OisState.OisStateEventVisitor<Void>() {
                    @Override
                    public Void onBooleanFunctionChanged(OisState.BooleanFunctionChanged event) {
                        if (event.getBooleanFunction() == BooleanFunction.IS_FULLY_DOCKED && event.getNewValue()) {
                            state.send(ShipCommand.UNDOCK);
                        }
                        if (event.getBooleanFunction() == BooleanFunction.IS_UNDOCKING && !event.getNewValue()) {
                            state.send(ShipCommand.DOCK);
                            count++;
                            if (count == 10) {
                                state.stop();
                            }
                        }
                        return null;
                    }

                    @Override
                    public Void onNumericalCommandChanged(OisState.NumericalCommandChanged event) {
                        return null;
                    }

                    @Override
                    public Void onActive() {
                        return null;
                    }
                });
            }
        });
    }
}
