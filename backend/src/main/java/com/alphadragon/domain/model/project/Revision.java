package com.alphadragon.domain.model.project;

import java.time.Instant;
import java.util.Objects;

public final class Revision {

    private final String revisionLabel;
    private final String description;
    private final Instant createdAt;

    public Revision(String revisionLabel, String description, Instant createdAt) {
        this.revisionLabel = Objects.requireNonNull(revisionLabel, "revisionLabel");
        this.description = Objects.requireNonNull(description, "description");
        this.createdAt = Objects.requireNonNull(createdAt, "createdAt");
    }

    public String revisionLabel() {
        return revisionLabel;
    }

    public String description() {
        return description;
    }

    public Instant createdAt() {
        return createdAt;
    }
}
