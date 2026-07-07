package com.alphadragon.domain.model.assembly;

import java.util.Objects;

public final class AssemblyInterface {

    private final String name;
    private final String interfaceDefinition;

    public AssemblyInterface(String name, String interfaceDefinition) {
        this.name = Objects.requireNonNull(name, "name");
        this.interfaceDefinition = Objects.requireNonNull(interfaceDefinition, "interfaceDefinition");
    }

    public String name() {
        return name;
    }

    public String interfaceDefinition() {
        return interfaceDefinition;
    }
}
