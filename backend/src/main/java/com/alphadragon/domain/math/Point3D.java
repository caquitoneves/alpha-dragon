package com.alphadragon.domain.math;

import java.util.Objects;

public final class Point3D {

    private final double x;
    private final double y;
    private final double z;

    public Point3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double x() {
        return x;
    }

    public double y() {
        return y;
    }

    public double z() {
        return z;
    }

    public Vector3D subtract(Point3D other) {
        Objects.requireNonNull(other, "other");
        return new Vector3D(x - other.x, y - other.y, z - other.z);
    }
}
