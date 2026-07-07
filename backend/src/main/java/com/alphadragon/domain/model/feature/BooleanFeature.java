package com.alphadragon.domain.model.feature;

/**
 * Represents a boolean feature operation between bodies.
 */
public sealed interface BooleanFeature extends Feature permits Union, Subtract, Intersect, Split, Shell, Offset, Mirror, Pattern {
}
