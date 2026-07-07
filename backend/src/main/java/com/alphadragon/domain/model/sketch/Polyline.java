package com.alphadragon.domain.model.sketch;

import com.alphadragon.domain.math.Point3D;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class Polyline implements SketchEntity {

    private final String entityId;
    private final List<Point3D> points;

    public Polyline(String entityId, List<Point3D> points) {
        this.entityId = Objects.requireNonNull(entityId, "entityId");
        this.points = Collections.unmodifiableList(Objects.requireNonNull(points, "points"));
    }

    @Override
    public String entityId() {
        return entityId;
    }

    public List<Point3D> points() {
        return points;
    }
}
