package com.alphadragon.domain.math;

public final class Matrix {

    private final double[][] values;

    public Matrix(double[][] values) {
        this.values = values.clone();
    }

    public double[][] values() {
        return values.clone();
    }
}
