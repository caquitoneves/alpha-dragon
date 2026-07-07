package com.alphadragon.domain.model.geometry;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class Topology {

    private final List<Face> faces;
    private final List<Edge> edges;
    private final List<Vertex> vertices;

    public Topology(List<Face> faces, List<Edge> edges, List<Vertex> vertices) {
        this.faces = Collections.unmodifiableList(Objects.requireNonNull(faces, "faces"));
        this.edges = Collections.unmodifiableList(Objects.requireNonNull(edges, "edges"));
        this.vertices = Collections.unmodifiableList(Objects.requireNonNull(vertices, "vertices"));
    }

    public List<Face> faces() {
        return faces;
    }

    public List<Edge> edges() {
        return edges;
    }

    public List<Vertex> vertices() {
        return vertices;
    }
}
