package com.alphadragon.domain.model.parametric;

import java.time.Instant;
import java.util.Objects;

public final class ParameterHistory {

    private final String parameterName;
    private final Object previousValue;
    private final Object newValue;
    private final Instant changedAt;

    public ParameterHistory(String parameterName, Object previousValue, Object newValue, Instant changedAt) {
        this.parameterName = Objects.requireNonNull(parameterName, "parameterName");
        this.previousValue = previousValue;
        this.newValue = newValue;
        this.changedAt = Objects.requireNonNull(changedAt, "changedAt");
    }

    public String parameterName() {
        return parameterName;
    }

    public Object previousValue() {
        return previousValue;
    }

    public Object newValue() {
        return newValue;
    }

    public Instant changedAt() {
        return changedAt;
    }
}
