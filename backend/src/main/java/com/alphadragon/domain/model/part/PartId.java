package com.alphadragon.domain.model.part;

import java.util.Objects;
import java.util.UUID;

public final class PartId {

    private final UUID value;

    private PartId(UUID value) {
        this.value = Objects.requireNonNull(value, "value");
    }

    public static PartId from(UUID value) {
        return new PartId(value);
    }

    public static PartId newId() {
        return new PartId(UUID.randomUUID());
    }

    public UUID value() {
        return value;
    }
}
