package com.alphadragon.domain.model.process;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class ManufacturingProcess {

    private final ProcessId id;
    private final String name;
    private final List<ProcessStep> steps;

    public ManufacturingProcess(ProcessId id, String name) {
        this.id = Objects.requireNonNull(id, "id");
        this.name = Objects.requireNonNull(name, "name");
        this.steps = new ArrayList<>();
    }

    public ProcessId id() {
        return id;
    }

    public String name() {
        return name;
    }

    public List<ProcessStep> steps() {
        return Collections.unmodifiableList(steps);
    }

    public void addStep(ProcessStep step) {
        Objects.requireNonNull(step, "step");
        steps.add(step);
    }
}
