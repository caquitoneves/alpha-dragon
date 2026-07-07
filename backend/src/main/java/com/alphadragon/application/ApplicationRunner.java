package com.alphadragon.application;

import com.alphadragon.application.usecase.AddAssemblyToProjectUseCase;
import com.alphadragon.application.usecase.CreateEngineeringProjectUseCase;
import com.alphadragon.domain.model.project.EngineeringProject;

public final class ApplicationRunner {

    public static void main(String[] args) {
        CreateEngineeringProjectUseCase createProjectUseCase = new CreateEngineeringProjectUseCase();
        EngineeringProject project = createProjectUseCase.execute("Alpha Dragon", "Platform application layer demo");

        AddAssemblyToProjectUseCase addAssemblyUseCase = new AddAssemblyToProjectUseCase();
        addAssemblyUseCase.execute(project, "Base Assembly");

        System.out.println("Project created: " + project.metadata().projectName());
        System.out.println("Assembly count: " + project.assemblies().size());
    }
}
