package com.alphadragon.domain.model.parametric;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;

public final class ParameterSnapshot {

    private final Map<String, Object> values;

    public ParameterSnapshot(Map<String, Object> values) {
        this.values = Collections.unmodifiableMap(Objects.requireNonNull(values, "values"));
    }

    public Map<String, Object> values() {
        return values;
    }
}
