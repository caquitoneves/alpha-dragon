package com.alphadragon.domain.model.feature;

public final class Pattern implements BooleanFeature {

    private final String featureId;
    private final String name;

    public Pattern(String featureId, String name) {
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
