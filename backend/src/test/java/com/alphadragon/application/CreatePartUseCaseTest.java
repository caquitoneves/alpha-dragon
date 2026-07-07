package com.alphadragon.application;

import com.alphadragon.application.usecase.CreatePartUseCase;
import com.alphadragon.domain.model.part.Part;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class CreatePartUseCaseTest {

    @Test
    void shouldCreatePartWithBodyAndMaterial() {
        CreatePartUseCase useCase = new CreatePartUseCase();
        Part part = useCase.execute("Bracket", "Steel", 12.5, 4.0);

        assertNotNull(part);
        assertEquals("Bracket", part.name());
        assertNotNull(part.body());
        assertEquals("Steel", part.material().name());
        assertEquals(12.5, part.massProperties().mass());
    }
}
