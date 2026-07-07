package com.alphadragon.domain.model.part;

import java.util.Objects;
import java.util.UUID;

public final class BodyId {

    private final UUID value;

    private BodyId(UUID value) {
        this.value = Objects.requireNonNull(value, "value");
    }

    public static BodyId from(UUID value) {
        return new BodyId(value);
    }

    public static BodyId newId() {
        return new BodyId(UUID.randomUUID());
    }

    public UUID value() {
        return value;
    }
}
