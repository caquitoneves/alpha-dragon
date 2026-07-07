package com.alphadragon.domain.model.parametric;

import java.util.Objects;

public final class Equation {

    private final Expression left;
    private final Expression right;

    public Equation(Expression left, Expression right) {
        this.left = Objects.requireNonNull(left, "left");
        this.right = Objects.requireNonNull(right, "right");
    }

    public Expression left() {
        return left;
    }

    public Expression right() {
        return right;
    }
}
