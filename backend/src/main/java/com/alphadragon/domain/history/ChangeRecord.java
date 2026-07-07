package com.alphadragon.domain.history;

import java.time.Instant;
import java.util.Objects;

public final class ChangeRecord {

    private final String recordId;
    private final String description;
    private final Instant changedAt;

    public ChangeRecord(String recordId, String description, Instant changedAt) {
        this.recordId = Objects.requireNonNull(recordId, "recordId");
        this.description = Objects.requireNonNull(description, "description");
        this.changedAt = Objects.requireNonNull(changedAt, "changedAt");
    }

    public String recordId() {
        return recordId;
    }

    public String description() {
        return description;
    }

    public Instant changedAt() {
        return changedAt;
    }
}
