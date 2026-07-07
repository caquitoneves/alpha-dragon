package com.alphadragon.domain.model.knowledge;

import java.util.List;
import java.util.Objects;

public final class ProfileLibrary {

    private final List<String> profileNames;

    public ProfileLibrary(List<String> profileNames) {
        this.profileNames = List.copyOf(Objects.requireNonNull(profileNames, "profileNames"));
    }

    public List<String> profileNames() {
        return profileNames;
    }
}
