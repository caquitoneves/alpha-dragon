package com.alphadragon.domain.service;

import com.alphadragon.domain.model.feature.Feature;
import com.alphadragon.domain.model.part.Body;

public final class FeatureApplicator {

    public void apply(Body body, Feature feature) {
        body.applyFeature(feature);
    }
}
