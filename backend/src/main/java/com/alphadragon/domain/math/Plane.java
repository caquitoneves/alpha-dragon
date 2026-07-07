package com.alphadragon.domain.math;

public final class Plane {

    private final Vector3D normal;
    private final double distance;

    public Plane(Vector3D normal, double distance) {
        this.normal = normal;
        this.distance = distance;
    }

    public Vector3D normal() {
        return normal;
    }

    public double distance() {
        return distance;
    }
}
