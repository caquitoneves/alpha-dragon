package com.alphadragon.domain.service;

import com.alphadragon.domain.specification.ValidationResult;

public final class EngineeringRuleEngine {

    public ValidationResult evaluate(Object subject) {
        return new ValidationResult(true, java.util.List.of());
    }
}
