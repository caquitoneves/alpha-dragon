package com.alphadragon.domain.model.geometry;

import com.alphadragon.domain.math.Point3D;
import java.util.Objects;

public final class Vertex {

    private final String id;
    private final Point3D position;

    public Vertex(String id, Point3D position) {
        this.id = Objects.requireNonNull(id, "id");
        this.position = Objects.requireNonNull(position, "position");
    }

    public String id() {
        return id;
    }

    public Point3D position() {
        return position;
    }
}
