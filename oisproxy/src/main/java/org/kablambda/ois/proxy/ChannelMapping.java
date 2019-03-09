package org.kablambda.ois.proxy;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

/**
 * This class keeps track of values from binary and numeric functions, and the mapping between output channels and functions
 * @param <F>
 * @param <V>
 */
public class ChannelMapping<F extends Enum,V> {
    private final Function<String, V> valueMapper;
    Map<Integer, F> functionChannelMapping = new HashMap<>();
    Map<F,V> functionValues = new HashMap<>();

    public ChannelMapping(Function<String,V> valueMapper) {
        this.valueMapper = valueMapper;
    }

    public void setMapping(int channel, F function) {
        functionChannelMapping.put(channel, function);
    }

    /**
     * Set a new value for a channel -- if the value changed or was previously not set, return the Function that was set
     * @param channel
     * @param newValueString
     * @return
     */
    public Optional<F> setValue(int channel, String newValueString) {
        F function = functionChannelMapping.get(channel);
        if (function == null) {
            // we don't map this channel
            return Optional.empty();
        } else {
            V newValue = valueMapper.apply(newValueString);
            V oldValue = functionValues.get(function);
            functionValues.put(function, newValue);
            return (oldValue == null || !oldValue.equals(newValue)) ? Optional.of(function) : Optional.empty();
        }
    }
}
