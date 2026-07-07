package com.alphadragon.domain.model.feature;

public final class Subtract implements BooleanFeature {

    private final String featureId;
    private final String name;

    public Subtract(String featureId, String name) {
        this.featureId = featureId;
        this.name = name;
    }

    @Override
    public String featureId() {
        return featureId;
    }

    @Override
    public String name() {
        return name;
    }
}
