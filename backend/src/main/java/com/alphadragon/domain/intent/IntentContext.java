package com.alphadragon.domain.intent;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;

public final class IntentContext {

    private final Map<String, Object> contextData;

    public IntentContext(Map<String, Object> contextData) {
        this.contextData = Collections.unmodifiableMap(Objects.requireNonNull(contextData, "contextData"));
    }

    public Map<String, Object> contextData() {
        return contextData;
    }
}
