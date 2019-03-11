package org.kablambda.ois.proxy;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

/**
 * This class keeps track of values from binary and numeric functions, and the mapping between output channels and functions
 *
 * @param <F>
 * @param <V>
 */
public class ChannelMapping<F extends Enum, V> {
    private final Function<String, V> valueMapper;
    private final StateEventFactory<F, V> stateEventFactory;
    private final Map<Integer, F> functionChannelMapping = new ConcurrentHashMap<>();
    private final Map<F, V> functionValues = new ConcurrentHashMap<>();

    public ChannelMapping(Function<String, V> valueMapper, StateEventFactory<F, V> stateEventFactory) {
        this.valueMapper = valueMapper;
        this.stateEventFactory = stateEventFactory;
    }

    public void setMapping(int channel, F function) {
        functionChannelMapping.put(channel, function);
    }

    /**
     * Set a new value for a channel -- if the value changed or was previously not set, return an event describing the change
     *
     * @param channel
     * @param newValueString
     * @return an event describing the change, or empty if nothing changed
     */
    public Optional<OisState.OisStateEvent> setValue(int channel, String newValueString) {
        F function = functionChannelMapping.get(channel);
        if (function == null) {
            // we don't map this channel
            return Optional.empty();
        } else {
            V newValue = valueMapper.apply(newValueString);
            V oldValue = functionValues.get(function);
            functionValues.put(function, newValue);
            return (oldValue == null || !oldValue.equals(newValue))
                    ? Optional.of(stateEventFactory.create(function, oldValue, newValue))
                    : Optional.empty();
        }
    }

    public Optional<V> getValue(F f) {
        return Optional.ofNullable(functionValues.get(f));
    }
}
