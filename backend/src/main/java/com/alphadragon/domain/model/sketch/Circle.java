package com.alphadragon.domain.model.sketch;

import com.alphadragon.domain.math.Point3D;
import java.util.Objects;

public final class Circle implements SketchEntity {

    private final String entityId;
    private final Point3D center;
    private final double radius;

    public Circle(String entityId, Point3D center, double radius) {
        this.entityId = Objects.requireNonNull(entityId, "entityId");
        this.center = Objects.requireNonNull(center, "center");
        this.radius = radius;
    }

    @Override
    public String entityId() {
        return entityId;
    }

    public Point3D center() {
        return center;
    }

    public double radius() {
        return radius;
    }
}
