package com.alphadragon.domain.model.process;

import java.util.Objects;

public final class ProcessStep {

    private final String name;
    private final ManufacturingStage stage;
    private final String description;

    public ProcessStep(String name, ManufacturingStage stage, String description) {
        this.name = Objects.requireNonNull(name, "name");
        this.stage = Objects.requireNonNull(stage, "stage");
        this.description = Objects.requireNonNull(description, "description");
    }

    public String name() {
        return name;
    }

    public ManufacturingStage stage() {
        return stage;
    }

    public String description() {
        return description;
    }
}
