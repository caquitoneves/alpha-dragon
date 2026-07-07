package com.alphadragon.domain.model.sketch;

import com.alphadragon.domain.math.Point3D;
import java.util.Objects;

public final class Line implements SketchEntity {

    private final String entityId;
    private final Point3D start;
    private final Point3D end;

    public Line(String entityId, Point3D start, Point3D end) {
        this.entityId = Objects.requireNonNull(entityId, "entityId");
        this.start = Objects.requireNonNull(start, "start");
        this.end = Objects.requireNonNull(end, "end");
    }

    @Override
    public String entityId() {
        return entityId;
    }

    public Point3D start() {
        return start;
    }

    public Point3D end() {
        return end;
    }
}
