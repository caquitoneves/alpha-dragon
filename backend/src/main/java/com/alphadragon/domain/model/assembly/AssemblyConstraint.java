package com.alphadragon.domain.model.assembly;

import java.util.Objects;

/**
 * Represents a constraint between assembly components.
 */
public final class AssemblyConstraint {

    private final String name;
    private final AssemblyConstraintType type;
    private final String description;

    public AssemblyConstraint(String name, AssemblyConstraintType type, String description) {
        this.name = Objects.requireNonNull(name, "name");
        this.type = Objects.requireNonNull(type, "type");
        this.description = Objects.requireNonNull(description, "description");
    }

    public String name() {
        return name;
    }

    public AssemblyConstraintType type() {
        return type;
    }

    public String description() {
        return description;
    }
}
