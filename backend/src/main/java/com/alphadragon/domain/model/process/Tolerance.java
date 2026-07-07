package com.alphadragon.domain.model.process;

import java.util.Objects;

public final class Tolerance {

    private final double minimum;
    private final double maximum;

    public Tolerance(double minimum, double maximum) {
        this.minimum = minimum;
        this.maximum = maximum;
    }

    public double minimum() {
        return minimum;
    }

    public double maximum() {
        return maximum;
    }
}
