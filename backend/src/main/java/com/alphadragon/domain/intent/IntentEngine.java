package com.alphadragon.domain.intent;

public final class IntentEngine {

    public IntentCommand translate(String userInstruction) {
        return new IntentCommand(userInstruction);
    }
}
