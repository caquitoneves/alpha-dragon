package com.alphadragon.domain.model.knowledge;

import java.util.List;
import java.util.Objects;

public final class MaterialCatalog {

    private final List<MaterialReference> materials;

    public MaterialCatalog(List<MaterialReference> materials) {
        this.materials = List.copyOf(Objects.requireNonNull(materials, "materials"));
    }

    public List<MaterialReference> materials() {
        return materials;
    }
}
