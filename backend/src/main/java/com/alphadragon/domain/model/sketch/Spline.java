package com.alphadragon.domain.model.sketch;

import com.alphadragon.domain.math.Point3D;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class Spline implements SketchEntity {

    private final String entityId;
    private final List<Point3D> controlPoints;

    public Spline(String entityId, List<Point3D> controlPoints) {
        this.entityId = Objects.requireNonNull(entityId, "entityId");
        this.controlPoints = Collections.unmodifiableList(Objects.requireNonNull(controlPoints, "controlPoints"));
    }

    @Override
    public String entityId() {
        return entityId;
    }

    public List<Point3D> controlPoints() {
        return controlPoints;
    }
}
