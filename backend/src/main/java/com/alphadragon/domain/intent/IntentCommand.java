package com.alphadragon.domain.intent;

import java.util.Objects;

public final class IntentCommand {

    private final String instruction;

    public IntentCommand(String instruction) {
        this.instruction = Objects.requireNonNull(instruction, "instruction");
    }

    public String instruction() {
        return instruction;
    }
}
