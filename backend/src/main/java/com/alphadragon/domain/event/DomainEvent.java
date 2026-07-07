package com.alphadragon.domain.event;

import java.time.Instant;

public abstract class DomainEvent {

    private final Instant occurredAt;

    protected DomainEvent(Instant occurredAt) {
        this.occurredAt = occurredAt;
    }

    public Instant occurredAt() {
        return occurredAt;
    }
}
