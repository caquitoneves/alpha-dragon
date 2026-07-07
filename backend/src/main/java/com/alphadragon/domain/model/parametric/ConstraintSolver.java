package com.alphadragon.domain.model.parametric;

import java.util.Objects;

public final class ConstraintSolver {

    public void solve(DependencyGraph graph, EvaluationContext context) {
        Objects.requireNonNull(graph, "graph");
        Objects.requireNonNull(context, "context");
    }
}
