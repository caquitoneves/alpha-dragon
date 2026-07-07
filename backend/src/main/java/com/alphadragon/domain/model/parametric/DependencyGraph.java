package com.alphadragon.domain.model.parametric;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;

public final class DependencyGraph {

    private final Map<String, String> dependencies;

    public DependencyGraph(Map<String, String> dependencies) {
        this.dependencies = Collections.unmodifiableMap(Objects.requireNonNull(dependencies, "dependencies"));
    }

    public Map<String, String> dependencies() {
        return dependencies;
    }
}
