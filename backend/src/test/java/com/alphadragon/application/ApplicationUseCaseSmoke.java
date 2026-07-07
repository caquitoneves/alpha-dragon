package com.alphadragon.application;

import com.alphadragon.application.usecase.AddAssemblyToProjectUseCase;
import com.alphadragon.application.usecase.CreateEngineeringProjectUseCase;
import com.alphadragon.domain.model.project.EngineeringProject;

public class ApplicationUseCaseSmoke {
    public static void main(String[] args) {
        CreateEngineeringProjectUseCase createProjectUseCase = new CreateEngineeringProjectUseCase();
        EngineeringProject project = createProjectUseCase.execute("Alpha Dragon", "Application layer smoke");

        AddAssemblyToProjectUseCase addAssemblyUseCase = new AddAssemblyToProjectUseCase();
        addAssemblyUseCase.execute(project, "Base Assembly");

        System.out.println(project.metadata().projectName());
        System.out.println(project.assemblies().size());
    }
}
