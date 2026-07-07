package com.alphadragon.domain.model.part;

import com.alphadragon.domain.math.Point3D;
import java.util.Objects;

/**
 * Value object representing mass properties of a part or body.
 */
public final class MassProperties {

    private final double mass;
    private final double volume;
    private final Point3D centerOfMass;

    public MassProperties(double mass, double volume, Point3D centerOfMass) {
        this.mass = mass;
        this.volume = volume;
        this.centerOfMass = Objects.requireNonNull(centerOfMass, "centerOfMass");
    }

    public double mass() {
        return mass;
    }

    public double volume() {
        return volume;
    }

    public Point3D centerOfMass() {
        return centerOfMass;
    }
}
