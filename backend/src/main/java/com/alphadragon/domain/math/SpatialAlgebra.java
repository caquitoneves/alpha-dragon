package com.alphadragon.domain.math;

public final class SpatialAlgebra {

    public double dot(Vector3D a, Vector3D b) {
        return a.x() * b.x() + a.y() * b.y() + a.z() * b.z();
    }
}
