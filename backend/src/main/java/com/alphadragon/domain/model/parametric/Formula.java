package com.alphadragon.domain.model.parametric;

import java.util.Objects;

public final class Formula {

    private final String name;
    private final Expression expression;

    public Formula(String name, Expression expression) {
        this.name = Objects.requireNonNull(name, "name");
        this.expression = Objects.requireNonNull(expression, "expression");
    }

    public String name() {
        return name;
    }

    public Expression expression() {
        return expression;
    }
}
