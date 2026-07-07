package com.alphadragon.application;

import com.alphadragon.application.usecase.AddAssemblyToProjectUseCase;
import com.alphadragon.application.usecase.CreateEngineeringProjectUseCase;
import com.alphadragon.domain.model.assembly.Assembly;
import com.alphadragon.domain.model.project.EngineeringProject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ApplicationUseCaseTest {

    @Test
    void shouldCreateProjectFromUseCase() {
        CreateEngineeringProjectUseCase useCase = new CreateEngineeringProjectUseCase();

        EngineeringProject project = useCase.execute("Alpha Dragon", "Initial platform scaffold");

        assertNotNull(project);
        assertEquals("Alpha Dragon", project.metadata().projectName());
    }

    @Test
    void shouldAddAssemblyToProject() {
        CreateEngineeringProjectUseCase createProjectUseCase = new CreateEngineeringProjectUseCase();
        EngineeringProject project = createProjectUseCase.execute("Alpha Dragon", "Assembly workflow");

        AddAssemblyToProjectUseCase addAssemblyUseCase = new AddAssemblyToProjectUseCase();
        Assembly assembly = addAssemblyUseCase.execute(project, "Base Assembly");

        assertNotNull(assembly);
        assertEquals(1, project.assemblies().size());
        assertEquals("Base Assembly", assembly.name());
    }
}
