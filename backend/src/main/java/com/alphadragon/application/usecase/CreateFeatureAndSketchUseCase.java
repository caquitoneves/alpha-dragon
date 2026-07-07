package com.alphadragon.application.usecase;

import com.alphadragon.domain.model.feature.Extrusion;
import com.alphadragon.domain.model.feature.Feature;
import com.alphadragon.domain.model.parametric.Parameter;
import com.alphadragon.domain.model.project.EngineeringProject;
import com.alphadragon.domain.model.sketch.Sketch;
import com.alphadragon.domain.model.sketch.SketchId;

import java.util.Objects;

public final class CreateFeatureAndSketchUseCase {

    public Result execute(EngineeringProject project, String featureName, String sketchName, String parameterName, double parameterValue) {
        Objects.requireNonNull(project, "project");
        Objects.requireNonNull(featureName, "featureName");
        Objects.requireNonNull(sketchName, "sketchName");
        Objects.requireNonNull(parameterName, "parameterName");

        Feature feature = new Extrusion(featureName.toLowerCase().replace(" ", "-"), featureName);
        Sketch sketch = new Sketch(SketchId.newId(), sketchName);
        Parameter parameter = new Parameter(parameterName, parameterValue);

        return new Result(feature, sketch, parameter);
    }

    public record Result(Feature feature, Sketch sketch, Parameter parameter) {
    }
}
