package com.alphadragon.domain.factory;

import com.alphadragon.domain.model.material.Material;
import com.alphadragon.domain.model.part.Body;
import com.alphadragon.domain.model.part.MassProperties;
import com.alphadragon.domain.model.part.Part;
import com.alphadragon.domain.model.part.PartId;
import com.alphadragon.domain.model.process.ManufacturingProcess;

public final class PartFactory {

    public Part create(PartId id, String name, Body body, Material material, MassProperties massProperties, ManufacturingProcess manufacturingProcess) {
        return new Part(id, name, body, material, massProperties, manufacturingProcess);
    }
}
