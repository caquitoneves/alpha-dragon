package com.alphadragon.domain.model.feature;

/**
 * Base contract for parametric feature operations.
 */
public sealed interface Feature permits Hole, Slot, Pocket, Fillet, Chamfer, ThreadFeature, Bend, Extrusion, Revolution, Cut, BooleanFeature {

    String featureId();

    String name();
}
