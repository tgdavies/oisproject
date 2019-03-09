package org.kablambda.ois.generateapi;

public class BooleanFunction {
    private final String name;
    private final String description;

    public BooleanFunction(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
