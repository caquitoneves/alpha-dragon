package com.alphadragon.domain.model.validation;

import com.alphadragon.domain.specification.ValidationResult;
import java.util.Objects;

public final class EngineeringValidation {

    private final String validationId;
    private final ValidationResult result;

    public EngineeringValidation(String validationId, ValidationResult result) {
        this.validationId = Objects.requireNonNull(validationId, "validationId");
        this.result = Objects.requireNonNull(result, "result");
    }

    public String validationId() {
        return validationId;
    }

    public ValidationResult result() {
        return result;
    }
}
