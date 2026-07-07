package com.alphadragon.domain.history;

import java.util.Objects;

public final class FeatureGraph {

    private final FeatureNode root;

    public FeatureGraph(FeatureNode root) {
        this.root = Objects.requireNonNull(root, "root");
    }

    public FeatureNode root() {
        return root;
    }
}
