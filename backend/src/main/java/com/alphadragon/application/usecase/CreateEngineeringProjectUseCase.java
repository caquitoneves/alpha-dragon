package com.alphadragon.application.usecase;

import com.alphadragon.domain.model.project.EngineeringProject;
import com.alphadragon.domain.model.project.ProjectId;
import com.alphadragon.domain.model.project.ProjectMetadata;

import java.time.Instant;
import java.util.Objects;

public final class CreateEngineeringProjectUseCase {

    public EngineeringProject execute(String name, String description) {
        Objects.requireNonNull(name, "name");
        Objects.requireNonNull(description, "description");

        ProjectMetadata metadata = new ProjectMetadata(name, description, Instant.now());
        return new EngineeringProject(ProjectId.newId(), metadata);
    }
}
