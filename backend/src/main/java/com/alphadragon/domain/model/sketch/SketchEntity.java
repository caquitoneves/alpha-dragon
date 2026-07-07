package com.alphadragon.domain.model.sketch;

public sealed interface SketchEntity permits Line, Circle, Arc, Spline, Polyline {

    String entityId();
}
