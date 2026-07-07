package com.alphadragon.domain.model.parametric;

import java.util.Objects;

public final class Expression {

    private final String expressionText;

    public Expression(String expressionText) {
        this.expressionText = Objects.requireNonNull(expressionText, "expressionText");
    }

    public String expressionText() {
        return expressionText;
    }

    public Object evaluate(EvaluationContext context) {
        Objects.requireNonNull(context, "context");
        return null;
    }
}
