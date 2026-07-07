package com.alphadragon.domain;

import com.alphadragon.domain.intent.IntentEngine;
import com.alphadragon.domain.kernel.GeometryKernel;
import com.alphadragon.domain.math.Point3D;
import com.alphadragon.domain.math.Vector3D;
import com.alphadragon.domain.model.assembly.Assembly;
import com.alphadragon.domain.model.assembly.AssemblyId;
import com.alphadragon.domain.model.assembly.CoordinateSystem;
import com.alphadragon.domain.model.geometry.BRep;
import com.alphadragon.domain.model.geometry.Geometry;
import com.alphadragon.domain.model.geometry.Topology;
import com.alphadragon.domain.model.part.Body;
import com.alphadragon.domain.model.part.BodyId;
import com.alphadragon.domain.model.part.MassProperties;
import com.alphadragon.domain.model.project.EngineeringProject;
import com.alphadragon.domain.model.project.ProjectId;
import com.alphadragon.domain.model.project.ProjectMetadata;
import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DomainSmokeTest {

    @Test
    void shouldCreateEngineeringProjectAndBodyKernel() {
        EngineeringProject project = new EngineeringProject(ProjectId.newId(), new ProjectMetadata("Alpha Dragon", "Domain kernel sample", Instant.now()));
        assertNotNull(project);

        Geometry geometry = new Geometry(new Topology(java.util.List.of(), java.util.List.of(), java.util.List.of()), new BRep(new Point3D[]{}));
        GeometryKernel kernel = new GeometryKernel(geometry);
        Body body = new Body(BodyId.newId(), kernel);

        assertEquals(kernel, body.geometryKernel());
    }

    @Test
    void shouldTranslateIntent() {
        IntentEngine intentEngine = new IntentEngine();
        assertNotNull(intentEngine.translate("Create a new part"));
    }

    @Test
    void shouldCreateAssemblyAndMassProperties() {
        EngineeringProject project = new EngineeringProject(ProjectId.newId(), new ProjectMetadata("Alpha Dragon", "Assembly sample", Instant.now()));
        Assembly assembly = new Assembly(AssemblyId.newId(), "Base Assembly", new CoordinateSystem(new Point3D(0, 0, 0), new Vector3D(1, 0, 0), new Vector3D(0, 1, 0), new Vector3D(0, 0, 1)));
        project.addAssembly(assembly);

        MassProperties massProperties = new MassProperties(12.5, 4.0, new Point3D(1, 2, 3));

        assertEquals(1, project.assemblies().size());
        assertEquals("Base Assembly", assembly.name());
        assertEquals(12.5, massProperties.mass());
    }
}
