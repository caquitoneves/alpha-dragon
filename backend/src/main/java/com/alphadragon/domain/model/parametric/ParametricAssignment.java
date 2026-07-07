package com.alphadragon.domain.model.parametric;

import java.util.Objects;

public final class ParametricAssignment {

    private final Parameter parameter;
    private final Expression expression;

    public ParametricAssignment(Parameter parameter, Expression expression) {
        this.parameter = Objects.requireNonNull(parameter, "parameter");
        this.expression = Objects.requireNonNull(expression, "expression");
    }

    public Parameter parameter() {
        return parameter;
    }

    public Expression expression() {
        return expression;
    }
}
