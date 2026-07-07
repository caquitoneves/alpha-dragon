package com.alphadragon.domain.model.part;

import com.alphadragon.domain.model.feature.Feature;
import com.alphadragon.domain.model.material.Material;
import com.alphadragon.domain.model.process.ManufacturingProcess;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Aggregate root representing a part in the engineering model.
 */
public final class Part {

    private final PartId id;
    private final String name;
    private final Body body;
    private final Material material;
    private final MassProperties massProperties;
    private final ManufacturingProcess manufacturingProcess;
    private final List<Feature> features;

    public Part(PartId id,
                String name,
                Body body,
                Material material,
                MassProperties massProperties,
                ManufacturingProcess manufacturingProcess) {
        this.id = Objects.requireNonNull(id, "id");
        this.name = Objects.requireNonNull(name, "name");
        this.body = Objects.requireNonNull(body, "body");
        this.material = Objects.requireNonNull(material, "material");
        this.massProperties = Objects.requireNonNull(massProperties, "massProperties");
        this.manufacturingProcess = Objects.requireNonNull(manufacturingProcess, "manufacturingProcess");
        this.features = new ArrayList<>();
    }

    public PartId id() {
        return id;
    }

    public String name() {
        return name;
    }

    public Body body() {
        return body;
    }

    public Material material() {
        return material;
    }

    public MassProperties massProperties() {
        return massProperties;
    }

    public ManufacturingProcess manufacturingProcess() {
        return manufacturingProcess;
    }

    public List<Feature> features() {
        return Collections.unmodifiableList(features);
    }

    public void addFeature(Feature feature) {
        Objects.requireNonNull(feature, "feature");
        features.add(feature);
    }
}
