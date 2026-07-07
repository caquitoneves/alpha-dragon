package com.alphadragon.domain.specification;

import java.util.List;
import java.util.Objects;

public final class ValidationResult {

    private final boolean valid;
    private final List<String> messages;

    public ValidationResult(boolean valid, List<String> messages) {
        this.valid = valid;
        this.messages = List.copyOf(Objects.requireNonNull(messages, "messages"));
    }

    public boolean valid() {
        return valid;
    }

    public List<String> messages() {
        return messages;
    }
}
