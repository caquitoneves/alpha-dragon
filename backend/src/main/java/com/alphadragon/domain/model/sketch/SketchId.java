package com.alphadragon.domain.model.sketch;

import java.util.Objects;
import java.util.UUID;

public final class SketchId {

    private final UUID value;

    private SketchId(UUID value) {
        this.value = Objects.requireNonNull(value, "value");
    }

    public static SketchId newId() {
        return new SketchId(UUID.randomUUID());
    }

    public UUID value() {
        return value;
    }
}
