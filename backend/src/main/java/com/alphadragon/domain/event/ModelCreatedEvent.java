package com.alphadragon.domain.event;

import java.time.Instant;

public final class ModelCreatedEvent extends DomainEvent {

    private final String modelId;

    public ModelCreatedEvent(String modelId, Instant occurredAt) {
        super(occurredAt);
        this.modelId = modelId;
    }

    public String modelId() {
        return modelId;
    }
}
