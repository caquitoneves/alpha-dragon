package com.alphadragon.domain.model.process;

import java.util.Objects;

public final class SurfaceFinish {

    private final String name;
    private final double roughness;

    public SurfaceFinish(String name, double roughness) {
        this.name = Objects.requireNonNull(name, "name");
        this.roughness = roughness;
    }

    public String name() {
        return name;
    }

    public double roughness() {
        return roughness;
    }
}
