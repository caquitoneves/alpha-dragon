package com.alphadragon.domain.intent;

public final class IntentTranslator {

    public IntentCommand translate(String text) {
        return new IntentCommand(text);
    }
}
