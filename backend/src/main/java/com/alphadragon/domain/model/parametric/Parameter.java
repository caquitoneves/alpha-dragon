package com.alphadragon.domain.model.parametric;

import java.util.Objects;

public final class Parameter {

    private final String name;
    private final Object value;

    public Parameter(String name, Object value) {
        this.name = Objects.requireNonNull(name, "name");
        this.value = Objects.requireNonNull(value, "value");
    }

    public String name() {
        return name;
    }

    public Object value() {
        return value;
    }
}
