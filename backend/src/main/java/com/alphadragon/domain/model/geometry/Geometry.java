package com.alphadragon.domain.model.geometry;

import java.util.Objects;

/**
 * Represents a geometric model with topology and boundary representation.
 */
public final class Geometry {

    private final Topology topology;
    private final BRep brep;

    public Geometry(Topology topology, BRep brep) {
        this.topology = Objects.requireNonNull(topology, "topology");
        this.brep = Objects.requireNonNull(brep, "brep");
    }

    public Topology topology() {
        return topology;
    }

    public BRep brep() {
        return brep;
    }

    public void validate() {
    }
}
