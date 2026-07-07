package com.alphadragon.domain.model.validation;

import java.util.Objects;

public final class EngineeringRule {

    private final String ruleId;
    private final String description;

    public EngineeringRule(String ruleId, String description) {
        this.ruleId = Objects.requireNonNull(ruleId, "ruleId");
        this.description = Objects.requireNonNull(description, "description");
    }

    public String ruleId() {
        return ruleId;
    }

    public String description() {
        return description;
    }
}
