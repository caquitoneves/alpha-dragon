package com.alphadragon.domain.specification;

public interface ManufacturingSpecification {

    ValidationResult evaluate(Object candidate);
}
