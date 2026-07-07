package com.alphadragon.domain.model.project;

import java.util.Objects;

/**
 * Documents the engineering artifact scope inside a project.
 */
public final class EngineeringDocument {

    private final DocumentId id;
    private final String name;
    private final String description;

    public EngineeringDocument(DocumentId id, String name, String description) {
        this.id = Objects.requireNonNull(id, "id");
        this.name = Objects.requireNonNull(name, "name");
        this.description = Objects.requireNonNull(description, "description");
    }

    public DocumentId id() {
        return id;
    }

    public String name() {
        return name;
    }

    public String description() {
        return description;
    }
}
