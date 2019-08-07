package com.example.demo.validator.mybatis;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER,ElementType.FIELD})
@Constraint(validatedBy = DeptValidatorClass.class)
public @interface DeptValidator {
    String values();
    String message() default "部门不存在";
    Class<?>[] groups() default {};
    Class<? extends Payload> [] payload() default {};
}
