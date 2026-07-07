package com.alphadragon.domain.model.feature;

public final class Hole implements Feature {

    private final String featureId;
    private final String name;
    private final double diameter;
    private final double depth;

    public Hole(String featureId, String name, double diameter, double depth) {
        this.featureId = featureId;
        this.name = name;
        this.diameter = diameter;
        this.depth = depth;
    }

    @Override
    public String featureId() {
        return featureId;
    }

    @Override
    public String name() {
        return name;
    }

    public double diameter() {
        return diameter;
    }

    public double depth() {
        return depth;
    }
}
