package com.example.demo.validator.mybatis;

import com.example.demo.entity.mybaites.Department;
import com.example.demo.repository.mybaites.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.*;


public class DeptValidatorClass implements ConstraintValidator<DeptValidator,Object> {

    private Long deptId;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public void initialize(DeptValidator deptValidator) {
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        Department department = departmentRepository.getDept(deptId);
        if (department!=null)
            return false;
        return true;
    }
}
