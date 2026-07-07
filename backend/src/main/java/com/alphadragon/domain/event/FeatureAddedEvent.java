package com.alphadragon.domain.event;

import java.time.Instant;

public final class FeatureAddedEvent extends DomainEvent {

    private final String featureId;

    public FeatureAddedEvent(String featureId, Instant occurredAt) {
        super(occurredAt);
        this.featureId = featureId;
    }

    public String featureId() {
        return featureId;
    }
}
