package com.microservices.template.shared.utils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class Validator<T> {
    public Set<ConstraintViolation<T>> validate(T target) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        javax.validation.Validator validator = factory.getValidator();

        return validator.validate(target);
    }
}
