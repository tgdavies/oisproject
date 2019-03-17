package org.kablambda.ois.proxy;

import org.kablambda.ois.proxy.OisState.OisStateEvent;

import java.util.List;

public class UiControllerHost {
    private final OisState state;
    private final List<UiController> controllers;

    public UiControllerHost(OisState state, List<UiController> controllers) {
        this.state = state;
        this.controllers = controllers;

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (; ; ) {
                    OisStateEvent event = state.getEvent();
                    if (event == null) {
                        System.out.println("Terminating");
                        return;
                    }
                    dispatch(event);
                }
            }
        }).start();
    }

    private void dispatch(OisStateEvent event) {
        for (UiController uic : controllers) {
            uic.onStateEvent(event, state);
        }
    }
}
