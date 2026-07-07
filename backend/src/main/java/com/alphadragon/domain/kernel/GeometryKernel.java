package com.alphadragon.domain.kernel;

import com.alphadragon.domain.model.geometry.BRep;
import com.alphadragon.domain.model.geometry.Geometry;
import com.alphadragon.domain.model.geometry.Topology;
import java.util.Objects;

/**
 * Kernel abstraction for internal geometry operations.
 */
public final class GeometryKernel {

    private final Geometry geometry;

    public GeometryKernel(Geometry geometry) {
        this.geometry = Objects.requireNonNull(geometry, "geometry");
    }

    public Geometry geometry() {
        return geometry;
    }

    public void heal() {
    }

    public void tessellate() {
    }

    public void offset(double distance) {
    }

    public void mirror() {
    }
}
