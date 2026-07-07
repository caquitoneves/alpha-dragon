package com.alphadragon.domain.model.project;

import java.time.Instant;
import java.util.Objects;

public final class ProjectMetadata {

    private final String projectName;
    private final String description;
    private final Instant createdAt;

    public ProjectMetadata(String projectName, String description, Instant createdAt) {
        this.projectName = Objects.requireNonNull(projectName, "projectName");
        this.description = Objects.requireNonNull(description, "description");
        this.createdAt = Objects.requireNonNull(createdAt, "createdAt");
    }

    public String projectName() {
        return projectName;
    }

    public String description() {
        return description;
    }

    public Instant createdAt() {
        return createdAt;
    }
}
