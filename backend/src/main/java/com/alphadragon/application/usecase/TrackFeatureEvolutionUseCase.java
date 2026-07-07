package com.alphadragon.application.usecase;

import com.alphadragon.domain.history.FeatureNode;
import com.alphadragon.domain.model.parametric.ParameterHistory;

import java.time.Instant;
import java.util.Objects;

public final class TrackFeatureEvolutionUseCase {

    public Result execute(String featureId, String featureName, String parameterName, Object previousValue, Object newValue) {
        Objects.requireNonNull(featureId, "featureId");
        Objects.requireNonNull(featureName, "featureName");
        Objects.requireNonNull(parameterName, "parameterName");
        Objects.requireNonNull(previousValue, "previousValue");
        Objects.requireNonNull(newValue, "newValue");

        FeatureNode featureNode = new FeatureNode(featureId, featureName);
        ParameterHistory parameterHistory = new ParameterHistory(parameterName, previousValue, newValue, Instant.now());
        return new Result(featureNode, parameterHistory);
    }

    public record Result(FeatureNode featureNode, ParameterHistory parameterHistory) {
    }
}
