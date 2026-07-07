package com.alphadragon.domain.model.sketch;

import com.alphadragon.domain.math.Point3D;
import java.util.Objects;

public final class Arc implements SketchEntity {

    private final String entityId;
    private final Point3D center;
    private final double radius;
    private final double startAngle;
    private final double endAngle;

    public Arc(String entityId, Point3D center, double radius, double startAngle, double endAngle) {
        this.entityId = Objects.requireNonNull(entityId, "entityId");
        this.center = Objects.requireNonNull(center, "center");
        this.radius = radius;
        this.startAngle = startAngle;
        this.endAngle = endAngle;
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

    public double startAngle() {
        return startAngle;
    }

    public double endAngle() {
        return endAngle;
    }
}
