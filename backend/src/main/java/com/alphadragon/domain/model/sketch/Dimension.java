package com.alphadragon.domain.model.sketch;

import java.util.Objects;

public final class Dimension {

    private final String label;
    private final double value;

    public Dimension(String label, double value) {
        this.label = Objects.requireNonNull(label, "label");
        this.value = value;
    }

    public String label() {
        return label;
    }

    public double value() {
        return value;
    }
}
