package com.alphadragon.infrastructure.persistence;

import com.alphadragon.domain.model.project.EngineeringProject;
import com.alphadragon.domain.model.project.ProjectId;
import com.alphadragon.domain.port.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class InMemoryEngineeringProjectRepository implements Repository {

    private final Map<ProjectId, EngineeringProject> projects = new ConcurrentHashMap<>();

    public void save(EngineeringProject project) {
        projects.put(project.projectId(), project);
    }

    public EngineeringProject findById(ProjectId id) {
        return projects.get(id);
    }
}
