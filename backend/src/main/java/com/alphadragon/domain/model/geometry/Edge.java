package com.alphadragon.domain.model.geometry;

import java.util.Objects;

public final class Edge {

    private final String name;
    private final Vertex start;
    private final Vertex end;

    public Edge(String name, Vertex start, Vertex end) {
        this.name = Objects.requireNonNull(name, "name");
        this.start = Objects.requireNonNull(start, "start");
        this.end = Objects.requireNonNull(end, "end");
    }

    public String name() {
        return name;
    }

    public Vertex start() {
        return start;
    }

    public Vertex end() {
        return end;
    }
}
