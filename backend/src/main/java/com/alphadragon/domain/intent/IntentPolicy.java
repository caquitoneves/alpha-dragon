package com.alphadragon.domain.intent;

public interface IntentPolicy {

    boolean allows(IntentCommand command);
}
