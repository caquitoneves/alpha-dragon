package com.alphadragon.domain.math;

public final class Projection {

    private final Vector3D direction;

    public Projection(Vector3D direction) {
        this.direction = direction;
    }

    public Vector3D direction() {
        return direction;
    }
}
