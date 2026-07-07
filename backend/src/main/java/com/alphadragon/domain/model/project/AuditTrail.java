package com.alphadragon.domain.model.project;

import java.time.Instant;
import java.util.Objects;

public final class AuditTrail {

    private final String actor;
    private final String action;
    private final Instant happenedAt;

    public AuditTrail(String actor, String action, Instant happenedAt) {
        this.actor = Objects.requireNonNull(actor, "actor");
        this.action = Objects.requireNonNull(action, "action");
        this.happenedAt = Objects.requireNonNull(happenedAt, "happenedAt");
    }

    public String actor() {
        return actor;
    }

    public String action() {
        return action;
    }

    public Instant happenedAt() {
        return happenedAt;
    }
}
