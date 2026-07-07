package com.alphadragon.domain.port;

import com.alphadragon.domain.specification.ValidationResult;

public interface ValidationPolicy {

    ValidationResult validate(Object candidate);
}
