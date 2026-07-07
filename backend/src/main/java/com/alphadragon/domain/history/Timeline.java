package com.alphadragon.domain.history;

import java.time.Instant;
import java.util.Objects;

public final class Timeline {

    private final String eventId;
    private final String description;
    private final Instant occurredAt;

    public Timeline(String eventId, String description, Instant occurredAt) {
        this.eventId = Objects.requireNonNull(eventId, "eventId");
        this.description = Objects.requireNonNull(description, "description");
        this.occurredAt = Objects.requireNonNull(occurredAt, "occurredAt");
    }

    public String eventId() {
        return eventId;
    }

    public String description() {
        return description;
    }

    public Instant occurredAt() {
        return occurredAt;
    }
}
