package com.example.gameboardspring.validations;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CheckArgumentsValidator.class)
public @interface CheckPathArguments {
    String message() default "INVALID_ARGUMENTS";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default  {};
}
