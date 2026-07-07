package com.alphadragon.domain.model.knowledge;

import java.util.Objects;

public final class Standard {

    private final String code;
    private final String title;

    public Standard(String code, String title) {
        this.code = Objects.requireNonNull(code, "code");
        this.title = Objects.requireNonNull(title, "title");
    }

    public String code() {
        return code;
    }

    public String title() {
        return title;
    }
}
