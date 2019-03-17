package org.kablambda.ois.proxy;

public interface UiController {
    void onStateEvent(OisState.OisStateEvent event, OisState state);
}
