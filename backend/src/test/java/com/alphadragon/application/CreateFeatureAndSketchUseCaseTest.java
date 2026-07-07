package com.alphadragon.application;

import com.alphadragon.application.usecase.CreateFeatureAndSketchUseCase;
import com.alphadragon.domain.model.feature.Extrusion;
import com.alphadragon.domain.model.parametric.Parameter;
import com.alphadragon.domain.model.project.EngineeringProject;
import com.alphadragon.domain.model.project.ProjectId;
import com.alphadragon.domain.model.project.ProjectMetadata;
import com.alphadragon.domain.model.sketch.Sketch;
import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class CreateFeatureAndSketchUseCaseTest {

    @Test
    void shouldCreateFeatureSketchAndParameter() {
        EngineeringProject project = new EngineeringProject(
                ProjectId.newId(),
                new ProjectMetadata("Alpha Dragon", "Feature sketch flow", Instant.now())
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

        CreateFeatureAndSketchUseCase useCase = new CreateFeatureAndSketchUseCase();
        var result = useCase.execute(project, "Extrusion", "Base Sketch", "depth", 20.0);

        assertNotNull(result);
        assertNotNull(result.feature());
        assertNotNull(result.sketch());
        assertNotNull(result.parameter());
        assertEquals("Extrusion", result.feature().name());
        assertEquals("Base Sketch", result.sketch().name());
        assertEquals("depth", result.parameter().name());
    }
}
