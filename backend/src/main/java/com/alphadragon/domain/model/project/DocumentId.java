package com.alphadragon.domain.model.project;

import java.util.Objects;
import java.util.UUID;

public final class DocumentId {

    private final UUID value;

    private DocumentId(UUID value) {
        this.value = Objects.requireNonNull(value, "value");
    }

    public static DocumentId from(UUID value) {
        return new DocumentId(value);
    }

    public static DocumentId newId() {
        return new DocumentId(UUID.randomUUID());
    }

    public UUID value() {
        return value;
    }
}
