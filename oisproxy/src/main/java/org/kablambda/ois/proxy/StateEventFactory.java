package org.kablambda.ois.proxy;

public interface StateEventFactory<F,V> {
    OisState.OisStateEvent create(F function, V oldValue, V newValue);
}
