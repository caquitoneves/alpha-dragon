package com.alphadragon.domain.model.feature;

public final class ThreadFeature implements Feature {

    private final String featureId;
    private final String name;

    public ThreadFeature(String featureId, String name) {
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
