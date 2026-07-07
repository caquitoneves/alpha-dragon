package com.alphadragon.domain.model.process;

import java.util.Objects;
import java.util.UUID;

public final class ProcessId {

    private final UUID value;

    private ProcessId(UUID value) {
        this.value = Objects.requireNonNull(value, "value");
    }

    public static ProcessId from(UUID value) {
        return new ProcessId(value);
    }

    public static ProcessId newId() {
        return new ProcessId(UUID.randomUUID());
    }

    public UUID value() {
        return value;
    }
}
