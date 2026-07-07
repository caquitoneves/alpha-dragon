package com.alphadragon.application.usecase;

import com.alphadragon.domain.model.feature.Feature;
import com.alphadragon.domain.model.part.Body;

import java.util.Objects;

public final class ApplyFeatureToBodyUseCase {

    public Body execute(Body body, Feature feature) {
        Objects.requireNonNull(body, "body");
        Objects.requireNonNull(feature, "feature");

        body.applyFeature(feature);
        return body;
    }
}
