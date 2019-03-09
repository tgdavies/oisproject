package org.kablambda.ois.generateapi;

import java.util.ArrayList;
import java.util.List;

/**
 * This class holds a parsed version of serial_commands.txt
 * It's very mutable.
 */
public class SerialCommands {
    private String version;
    private final List<NumericalCommand> numericalCommands = new ArrayList<>();
    private final List<BooleanFunction> booleanFunctions = new ArrayList<>();
    private final List<ShipCommand> shipCommands = new ArrayList<>();

    public void setVersion(String version) {
        this.version = version;
    }

    public String getVersion() {
        return version;
    }

    public List<NumericalCommand> getNumericalCommands() {
        return numericalCommands;
    }

    public List<BooleanFunction> getBooleanFunctions() {
        return booleanFunctions;
    }

    public List<ShipCommand> getShipCommands() {
        return shipCommands;
    }
}
