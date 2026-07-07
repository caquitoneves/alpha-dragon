package com.alphadragon.domain.math;

public final class Transform {

    private final Matrix matrix;

    public Transform(Matrix matrix) {
        this.matrix = matrix;
    }

    public Matrix matrix() {
        return matrix;
    }
}
