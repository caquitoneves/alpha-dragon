package com.alphadragon.domain.model.knowledge;

import java.util.List;
import java.util.Objects;

public final class FastenerLibrary {

    private final List<String> fastenerTypes;

    public FastenerLibrary(List<String> fastenerTypes) {
        this.fastenerTypes = List.copyOf(Objects.requireNonNull(fastenerTypes, "fastenerTypes"));
    }

    public List<String> fastenerTypes() {
        return fastenerTypes;
    }
}
