package com.alphadragon.domain.event;

import java.time.Instant;

public final class ValidationFailedEvent extends DomainEvent {

    private final String validationId;

    public ValidationFailedEvent(String validationId, Instant occurredAt) {
        super(occurredAt);
        this.validationId = validationId;
    }

    public String validationId() {
        return validationId;
    }
}
