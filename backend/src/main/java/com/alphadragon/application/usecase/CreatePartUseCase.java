package com.alphadragon.application.usecase;

import com.alphadragon.domain.kernel.GeometryKernel;
import com.alphadragon.domain.math.Point3D;
import com.alphadragon.domain.model.geometry.BRep;
import com.alphadragon.domain.model.geometry.Geometry;
import com.alphadragon.domain.model.geometry.Topology;
import com.alphadragon.domain.model.material.Material;
import com.alphadragon.domain.model.material.MaterialType;
import com.alphadragon.domain.model.part.Body;
import com.alphadragon.domain.model.part.BodyId;
import com.alphadragon.domain.model.part.MassProperties;
import com.alphadragon.domain.model.part.Part;
import com.alphadragon.domain.model.part.PartId;
import com.alphadragon.domain.model.process.ManufacturingProcess;
import com.alphadragon.domain.model.process.ManufacturingStage;
import com.alphadragon.domain.model.process.ProcessId;
import com.alphadragon.domain.model.process.ProcessStep;
import com.alphadragon.domain.model.process.SurfaceFinish;
import com.alphadragon.domain.model.process.Tolerance;

import java.util.List;
import java.util.Objects;

public final class CreatePartUseCase {

    public Part execute(String partName, String materialName, double mass, double volume) {
        Objects.requireNonNull(partName, "partName");
        Objects.requireNonNull(materialName, "materialName");

        Geometry geometry = new Geometry(new Topology(List.of(), List.of(), List.of()), new BRep(new Point3D[] {}));
        GeometryKernel kernel = new GeometryKernel(geometry);
        Body body = new Body(BodyId.newId(), kernel);

        Material material = new Material(materialName, MaterialType.METAL, 7.85);
        MassProperties massProperties = new MassProperties(mass, volume, new Point3D(0, 0, 0));
        ManufacturingProcess manufacturingProcess = new ManufacturingProcess(ProcessId.newId(), "process-1");
        manufacturingProcess.addStep(new ProcessStep("step-1", ManufacturingStage.CNC, "Machining"));

        return new Part(PartId.newId(), partName, body, material, massProperties, manufacturingProcess);
    }
}
