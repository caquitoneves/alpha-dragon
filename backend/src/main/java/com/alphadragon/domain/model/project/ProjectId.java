package com.alphadragon.domain.model.project;

import java.util.Objects;
import java.util.UUID;

public final class ProjectId {

    private final UUID value;

    private ProjectId(UUID value) {
        this.value = Objects.requireNonNull(value, "value");
    }

    public static ProjectId from(UUID value) {
        return new ProjectId(value);
    }

    public static ProjectId newId() {
        return new ProjectId(UUID.randomUUID());
    }

    public UUID value() {
        return value;
    }
}
