package com.alphadragon.domain.model.knowledge;

import java.util.Objects;

public final class MaterialReference {

    private final String name;
    private final String code;

    public MaterialReference(String name, String code) {
        this.name = Objects.requireNonNull(name, "name");
        this.code = Objects.requireNonNull(code, "code");
    }

    public String name() {
        return name;
    }

    public String code() {
        return code;
    }
}
