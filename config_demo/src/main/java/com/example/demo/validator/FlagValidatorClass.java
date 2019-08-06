package com.example.demo.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class FlagValidatorClass implements ConstraintValidator<FlagValidator,Object> {

    private String values;

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
        String[] value_array = values.split(",");
        boolean isFlag = false;
        for (String va: value_array){
            if (va.equals(value)){
                isFlag = true;
                break;
            }
        }
        return isFlag;
    }

    @Override
    public void initialize(FlagValidator constraintAnnotation) {
        this.values = constraintAnnotation.values();
    }
}
