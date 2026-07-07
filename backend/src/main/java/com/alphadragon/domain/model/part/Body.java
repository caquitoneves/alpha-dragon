package com.alphadragon.domain.model.part;

import com.alphadragon.domain.kernel.GeometryKernel;
import com.alphadragon.domain.model.feature.Feature;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Represents a solid body and the operations that modify it.
 */
public final class Body {

    private final BodyId id;
    private final GeometryKernel geometryKernel;
    private final List<Feature> appliedFeatures;

    public Body(BodyId id, GeometryKernel geometryKernel) {
        this.id = Objects.requireNonNull(id, "id");
        this.geometryKernel = Objects.requireNonNull(geometryKernel, "geometryKernel");
        this.appliedFeatures = new ArrayList<>();
    }

    public BodyId id() {
        return id;
    }

    public GeometryKernel geometryKernel() {
        return geometryKernel;
    }

    public List<Feature> appliedFeatures() {
        return Collections.unmodifiableList(appliedFeatures);
    }

    public void applyFeature(Feature feature) {
        Objects.requireNonNull(feature, "feature");
        appliedFeatures.add(feature);
    }

    public void union(Body other) {
        Objects.requireNonNull(other, "other");
    }

    public void subtract(Body other) {
        Objects.requireNonNull(other, "other");
    }

    public void intersect(Body other) {
        Objects.requireNonNull(other, "other");
    }
}
