package com.alphadragon.domain.model.assembly;

import java.util.Objects;
import java.util.UUID;

public final class AssemblyId {

    private final UUID value;

    private AssemblyId(UUID value) {
        this.value = Objects.requireNonNull(value, "value");
    }

    public static AssemblyId from(UUID value) {
        return new AssemblyId(value);
    }

    public static AssemblyId newId() {
        return new AssemblyId(UUID.randomUUID());
    }

    public UUID value() {
        return value;
    }
}
