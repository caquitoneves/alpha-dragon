package com.alphadragon.domain.model.assembly;

import com.alphadragon.domain.math.Point3D;
import com.alphadragon.domain.math.Vector3D;
import java.util.Objects;

public final class CoordinateSystem {

    private final Point3D origin;
    private final Vector3D xAxis;
    private final Vector3D yAxis;
    private final Vector3D zAxis;

    public CoordinateSystem(Point3D origin, Vector3D xAxis, Vector3D yAxis, Vector3D zAxis) {
        this.origin = Objects.requireNonNull(origin, "origin");
        this.xAxis = Objects.requireNonNull(xAxis, "xAxis");
        this.yAxis = Objects.requireNonNull(yAxis, "yAxis");
        this.zAxis = Objects.requireNonNull(zAxis, "zAxis");
    }

    public Point3D origin() {
        return origin;
    }

    public Vector3D xAxis() {
        return xAxis;
    }

    public Vector3D yAxis() {
        return yAxis;
    }

    public Vector3D zAxis() {
        return zAxis;
    }
}
