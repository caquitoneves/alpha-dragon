package com.alphadragon.domain.specification;

public interface ToleranceSpecification {

    ValidationResult evaluate(Object candidate);
}
