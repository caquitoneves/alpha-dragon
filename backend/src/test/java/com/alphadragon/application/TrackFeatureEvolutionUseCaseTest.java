package com.alphadragon.application;

import com.alphadragon.application.usecase.TrackFeatureEvolutionUseCase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class TrackFeatureEvolutionUseCaseTest {

    @Test
    void shouldTrackParameterEvolutionForFeature() {
        TrackFeatureEvolutionUseCase useCase = new TrackFeatureEvolutionUseCase();
        TrackFeatureEvolutionUseCase.Result result = useCase.execute("feature-1", "Extrusion", "depth", 5.0, 20.0);

        assertNotNull(result);
        assertNotNull(result.featureNode());
        assertNotNull(result.parameterHistory());
        assertEquals("Extrusion", result.featureNode().name());
        assertEquals("depth", result.parameterHistory().parameterName());
        assertEquals(5.0, result.parameterHistory().previousValue());
        assertEquals(20.0, result.parameterHistory().newValue());
    }
}
