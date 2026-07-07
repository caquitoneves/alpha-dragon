package com.alphadragon.infrastructure;

import com.alphadragon.domain.model.project.EngineeringProject;
import com.alphadragon.domain.model.project.ProjectId;
import com.alphadragon.domain.model.project.ProjectMetadata;
import com.alphadragon.infrastructure.persistence.InMemoryEngineeringProjectRepository;
import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

class InMemoryEngineeringProjectRepositoryTest {

    @Test
    void shouldSaveAndLoadProjectById() {
        InMemoryEngineeringProjectRepository repository = new InMemoryEngineeringProjectRepository();
        EngineeringProject project = new EngineeringProject(
                ProjectId.newId(),
                new ProjectMetadata("Alpha Dragon", "Stored", Instant.now())
        );

        repository.save(project);
        EngineeringProject loaded = repository.findById(project.projectId());

        assertNotNull(loaded);
        assertEquals(project.projectId().value(), loaded.projectId().value());
    }

    @Test
    void shouldReturnNullWhenProjectDoesNotExist() {
        InMemoryEngineeringProjectRepository repository = new InMemoryEngineeringProjectRepository();
        assertNull(repository.findById(ProjectId.newId()));
    }
}
