package com.alphadragon.domain.factory;

import com.alphadragon.domain.kernel.GeometryKernel;
import com.alphadragon.domain.model.part.Body;
import com.alphadragon.domain.model.part.BodyId;

public final class BodyFactory {

    public Body create(BodyId id, GeometryKernel kernel) {
        return new Body(id, kernel);
    }
}
