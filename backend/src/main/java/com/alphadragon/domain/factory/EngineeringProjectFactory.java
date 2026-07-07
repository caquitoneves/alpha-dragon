package com.alphadragon.domain.factory;

import com.alphadragon.domain.model.project.EngineeringProject;
import com.alphadragon.domain.model.project.ProjectId;
import com.alphadragon.domain.model.project.ProjectMetadata;

public final class EngineeringProjectFactory {

    public EngineeringProject create(ProjectId id, ProjectMetadata metadata) {
        return new EngineeringProject(id, metadata);
    }
}
