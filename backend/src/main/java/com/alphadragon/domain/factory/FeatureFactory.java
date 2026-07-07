package com.alphadragon.domain.factory;

import com.alphadragon.domain.model.feature.Feature;

public final class FeatureFactory {

    public Feature createHole(String featureId, String name, double diameter, double depth) {
        return new com.alphadragon.domain.model.feature.Hole(featureId, name, diameter, depth);
    }
}
