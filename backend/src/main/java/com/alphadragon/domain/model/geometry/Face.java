package com.alphadragon.domain.model.geometry;

import java.util.Objects;

public final class Face {

    private final String name;
    private final SurfaceType surfaceType;

    public Face(String name, SurfaceType surfaceType) {
        this.name = Objects.requireNonNull(name, "name");
        this.surfaceType = Objects.requireNonNull(surfaceType, "surfaceType");
    }

    public String name() {
        return name;
    }

    public SurfaceType surfaceType() {
        return surfaceType;
    }
}
