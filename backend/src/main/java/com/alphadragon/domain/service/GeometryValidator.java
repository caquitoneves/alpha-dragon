package com.alphadragon.domain.service;

import com.alphadragon.domain.model.geometry.Geometry;
import com.alphadragon.domain.specification.ValidationResult;

public final class GeometryValidator {

    public ValidationResult validate(Geometry geometry) {
        return new ValidationResult(true, java.util.List.of());
    }
}
