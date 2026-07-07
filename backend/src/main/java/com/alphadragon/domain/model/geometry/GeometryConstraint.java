package com.alphadragon.domain.model.geometry;

import java.util.Objects;

public final class GeometryConstraint {

    private final String description;
    private final ConstraintType type;

    public GeometryConstraint(String description, ConstraintType type) {
        this.description = Objects.requireNonNull(description, "description");
        this.type = Objects.requireNonNull(type, "type");
    }

    public String description() {
        return description;
    }

    public ConstraintType type() {
        return type;
    }
}
