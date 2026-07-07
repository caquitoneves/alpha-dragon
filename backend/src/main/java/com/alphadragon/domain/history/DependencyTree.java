package com.alphadragon.domain.history;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;

public final class DependencyTree {

    private final Map<String, String> edges;

    public DependencyTree(Map<String, String> edges) {
        this.edges = Collections.unmodifiableMap(Objects.requireNonNull(edges, "edges"));
    }

    public Map<String, String> edges() {
        return edges;
    }
}
