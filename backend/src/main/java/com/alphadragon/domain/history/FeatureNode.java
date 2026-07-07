package com.alphadragon.domain.history;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class FeatureNode {

    private final String id;
    private final String name;
    private final List<FeatureNode> children;

    public FeatureNode(String id, String name) {
        this.id = Objects.requireNonNull(id, "id");
        this.name = Objects.requireNonNull(name, "name");
        this.children = new ArrayList<>();
    }

    public String id() {
        return id;
    }

    public String name() {
        return name;
    }

    public List<FeatureNode> children() {
        return Collections.unmodifiableList(children);
    }

    public void addChild(FeatureNode child) {
        Objects.requireNonNull(child, "child");
        children.add(child);
    }
}
