package com.alphadragon.domain.model.feature;

public final class Revolution implements Feature {

    private final String featureId;
    private final String name;

    public Revolution(String featureId, String name) {
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
