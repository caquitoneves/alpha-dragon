package com.alphadragon.domain.model.geometry;

import com.alphadragon.domain.math.Point3D;
import java.util.Objects;

public final class BRep {

    private final Point3D[] controlPoints;

    public BRep(Point3D[] controlPoints) {
        this.controlPoints = Objects.requireNonNull(controlPoints, "controlPoints");
    }

    public Point3D[] controlPoints() {
        return controlPoints.clone();
    }
}
