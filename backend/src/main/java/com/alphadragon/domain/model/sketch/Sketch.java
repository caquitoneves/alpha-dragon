package com.alphadragon.domain.model.sketch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class Sketch {

    private final SketchId id;
    private final String name;
    private final List<SketchEntity> entities;
    private final List<SketchConstraint> constraints;

    public Sketch(SketchId id, String name) {
        this.id = Objects.requireNonNull(id, "id");
        this.name = Objects.requireNonNull(name, "name");
        this.entities = new ArrayList<>();
        this.constraints = new ArrayList<>();
    }

    public SketchId id() {
        return id;
    }

    public String name() {
        return name;
    }

    public List<SketchEntity> entities() {
        return Collections.unmodifiableList(entities);
    }

    public List<SketchConstraint> constraints() {
        return Collections.unmodifiableList(constraints);
    }

    public void addEntity(SketchEntity entity) {
        Objects.requireNonNull(entity, "entity");
        entities.add(entity);
    }

    public void addConstraint(SketchConstraint constraint) {
        Objects.requireNonNull(constraint, "constraint");
        constraints.add(constraint);
    }
}
