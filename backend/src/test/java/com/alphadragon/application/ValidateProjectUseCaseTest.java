package com.alphadragon.application;

import com.alphadragon.application.usecase.ValidateProjectUseCase;
import com.alphadragon.domain.model.project.EngineeringProject;
import com.alphadragon.domain.model.project.ProjectId;
import com.alphadragon.domain.model.project.ProjectMetadata;
import com.alphadragon.domain.specification.ValidationResult;
import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidateProjectUseCaseTest {

    @Test
    void shouldReturnInvalidWhenProjectHasNoAssemblies() {
        EngineeringProject project = new EngineeringProject(
                ProjectId.newId(),
                new ProjectMetadata("Alpha Dragon", "No assemblies", Instant.now())
        );

        ValidateProjectUseCase useCase = new ValidateProjectUseCase();
        ValidationResult result = useCase.execute(project);

        assertFalse(result.valid());
        assertFalse(result.messages().isEmpty());
    }

    @Test
    void shouldReturnValidWhenProjectHasAssemblies() {
        EngineeringProject project = new EngineeringProject(
                ProjectId.newId(),
                new ProjectMetadata("Alpha Dragon", "With assembly", Instant.now())
        );
        project.addAssembly(new com.alphadragon.domain.model.assembly.Assembly(
                com.alphadragon.domain.model.assembly.AssemblyId.newId(),
                "Base Assembly",
                new com.alphadragon.domain.model.assembly.CoordinateSystem(
                        new com.alphadragon.domain.math.Point3D(0, 0, 0),
                        new com.alphadragon.domain.math.Vector3D(1, 0, 0),
                        new com.alphadragon.domain.math.Vector3D(0, 1, 0),
                        new com.alphadragon.domain.math.Vector3D(0, 0, 1)
                )
        ));

        ValidateProjectUseCase useCase = new ValidateProjectUseCase();
        ValidationResult result = useCase.execute(project);

        assertTrue(result.valid());
    }
}
