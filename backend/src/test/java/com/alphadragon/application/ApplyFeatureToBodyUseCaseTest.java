package com.alphadragon.application;

import com.alphadragon.application.usecase.ApplyFeatureToBodyUseCase;
import com.alphadragon.domain.kernel.GeometryKernel;
import com.alphadragon.domain.math.Point3D;
import com.alphadragon.domain.model.feature.Extrusion;
import com.alphadragon.domain.model.geometry.BRep;
import com.alphadragon.domain.model.geometry.Geometry;
import com.alphadragon.domain.model.geometry.Topology;
import com.alphadragon.domain.model.part.Body;
import com.alphadragon.domain.model.part.BodyId;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ApplyFeatureToBodyUseCaseTest {

    @Test
    void shouldApplyFeatureToBody() {
        Geometry geometry = new Geometry(new Topology(List.of(), List.of(), List.of()), new BRep(new Point3D[] {}));
        GeometryKernel kernel = new GeometryKernel(geometry);
        Body body = new Body(BodyId.newId(), kernel);
        Extrusion feature = new Extrusion("extrusion-1", "Extrusion");

        ApplyFeatureToBodyUseCase useCase = new ApplyFeatureToBodyUseCase();
        Body updatedBody = useCase.execute(body, feature);

        assertNotNull(updatedBody);
        assertEquals(1, updatedBody.appliedFeatures().size());
        assertEquals("Extrusion", updatedBody.appliedFeatures().get(0).name());
    }
}
