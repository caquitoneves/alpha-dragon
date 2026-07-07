package com.alphadragon.domain.service;

import com.alphadragon.domain.model.project.EngineeringProject;
import com.alphadragon.domain.specification.ValidationResult;

import java.util.ArrayList;
import java.util.List;

public final class EngineeringRuleEngine {

    public ValidationResult evaluate(Object subject) {
        if (subject instanceof EngineeringProject project) {
            List<String> messages = new ArrayList<>();

            if (project.assemblies().isEmpty()) {
                messages.add("Project must contain at least one assembly.");
            }

            return new ValidationResult(messages.isEmpty(), messages);
        }

        return new ValidationResult(true, List.of());
    }
}
