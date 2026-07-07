package com.alphadragon.application.usecase;

import com.alphadragon.domain.math.Point3D;
import com.alphadragon.domain.math.Vector3D;
import com.alphadragon.domain.model.assembly.Assembly;
import com.alphadragon.domain.model.assembly.AssemblyId;
import com.alphadragon.domain.model.assembly.CoordinateSystem;
import com.alphadragon.domain.model.project.EngineeringProject;

import java.util.Objects;

public final class AddAssemblyToProjectUseCase {

    public Assembly execute(EngineeringProject project, String assemblyName) {
        Objects.requireNonNull(project, "project");
        Objects.requireNonNull(assemblyName, "assemblyName");

        Assembly assembly = new Assembly(
                AssemblyId.newId(),
                assemblyName,
                new CoordinateSystem(
                        new Point3D(0, 0, 0),
                        new Vector3D(1, 0, 0),
                        new Vector3D(0, 1, 0),
                        new Vector3D(0, 0, 1)
                )
        );

        project.addAssembly(assembly);
        return assembly;
    }
}
