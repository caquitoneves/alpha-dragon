package com.alphadragon.application.usecase;

import com.alphadragon.domain.model.project.EngineeringProject;
import com.alphadragon.domain.service.EngineeringRuleEngine;
import com.alphadragon.domain.specification.ValidationResult;

import java.util.Objects;

public final class ValidateProjectUseCase {

    public ValidationResult execute(EngineeringProject project) {
        Objects.requireNonNull(project, "project");
        return new EngineeringRuleEngine().evaluate(project);
    }
}
