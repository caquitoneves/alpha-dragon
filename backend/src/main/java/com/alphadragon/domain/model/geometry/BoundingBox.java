package com.alphadragon.domain.model.geometry;

import com.alphadragon.domain.math.Point3D;
import java.util.Objects;

public final class BoundingBox {

    private final Point3D minimum;
    private final Point3D maximum;

    public BoundingBox(Point3D minimum, Point3D maximum) {
        this.minimum = Objects.requireNonNull(minimum, "minimum");
        this.maximum = Objects.requireNonNull(maximum, "maximum");
    }

    public Point3D minimum() {
        return minimum;
    }

    public Point3D maximum() {
        return maximum;
    }
}
