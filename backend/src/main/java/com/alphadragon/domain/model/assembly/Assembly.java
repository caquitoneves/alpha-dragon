package com.alphadragon.domain.model.assembly;

import com.alphadragon.domain.model.part.Part;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Aggregate root representing an assembly of parts.
 */
public final class Assembly {

    private final AssemblyId id;
    private final String name;
    private final List<Part> parts;
    private final List<AssemblyConstraint> constraints;
    private final CoordinateSystem coordinateSystem;

    public Assembly(AssemblyId id, String name, CoordinateSystem coordinateSystem) {
        this.id = Objects.requireNonNull(id, "id");
        this.name = Objects.requireNonNull(name, "name");
        this.coordinateSystem = Objects.requireNonNull(coordinateSystem, "coordinateSystem");
        this.parts = new ArrayList<>();
        this.constraints = new ArrayList<>();
    }

    public AssemblyId id() {
        return id;
    }

    public String name() {
        return name;
    }

    public CoordinateSystem coordinateSystem() {
        return coordinateSystem;
    }

    public List<Part> parts() {
        return Collections.unmodifiableList(parts);
    }

    public List<AssemblyConstraint> constraints() {
        return Collections.unmodifiableList(constraints);
    }

    public void addPart(Part part) {
        Objects.requireNonNull(part, "part");
        parts.add(part);
    }

    public void addConstraint(AssemblyConstraint constraint) {
        Objects.requireNonNull(constraint, "constraint");
        constraints.add(constraint);
    }
}
