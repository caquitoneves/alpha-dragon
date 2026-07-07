package com.alphadragon.domain.service;

import com.alphadragon.domain.model.part.Body;
import com.alphadragon.domain.model.part.MassProperties;

public final class MassPropertiesCalculator {

    public MassProperties calculate(Body body) {
        return new MassProperties(0.0, 0.0, new com.alphadragon.domain.math.Point3D(0.0, 0.0, 0.0));
    }
}
