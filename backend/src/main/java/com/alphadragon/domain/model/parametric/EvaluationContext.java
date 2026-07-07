package com.alphadragon.domain.model.parametric;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;

public final class EvaluationContext {

    private final Map<String, Object> variables;

    public EvaluationContext(Map<String, Object> variables) {
        this.variables = Collections.unmodifiableMap(Objects.requireNonNull(variables, "variables"));
    }

    public Map<String, Object> variables() {
        return variables;
    }
}
