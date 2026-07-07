package com.alphadragon.domain.model.material;

import java.util.Objects;

/**
 * Value object representing engineering material properties.
 */
public final class Material {

    private final String name;
    private final MaterialType type;
    private final double density;

    public Material(String name, MaterialType type, double density) {
        this.name = Objects.requireNonNull(name, "name");
        this.type = Objects.requireNonNull(type, "type");
        this.density = density;
    }

    public String name() {
        return name;
    }

    public MaterialType type() {
        return type;
    }

    public double density() {
        return density;
    }
}
