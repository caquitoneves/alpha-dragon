package com.alphadragon.domain.math;

public final class Rotation {

    private final Quaternion quaternion;

    public Rotation(Quaternion quaternion) {
        this.quaternion = quaternion;
    }

    public Quaternion quaternion() {
        return quaternion;
    }
}
