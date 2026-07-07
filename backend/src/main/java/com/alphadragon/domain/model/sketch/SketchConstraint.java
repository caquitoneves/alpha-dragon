package com.alphadragon.domain.model.sketch;

import java.util.Objects;

public final class SketchConstraint {

    private final String description;
    private final SketchConstraintType type;

    public SketchConstraint(String description, SketchConstraintType type) {
        this.description = Objects.requireNonNull(description, "description");
        this.type = Objects.requireNonNull(type, "type");
    }

    public String description() {
        return description;
    }

    public SketchConstraintType type() {
        return type;
    }
}
