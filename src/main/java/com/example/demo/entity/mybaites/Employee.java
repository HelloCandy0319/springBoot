package com.example.demo.entity.mybaites;

import com.example.demo.validator.mybatis.DeptValidator;
import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class Employee implements Serializable {
    private Long id;
    @Column(name = "employee_name")
    private String employeeName;
    @Max(value = 100,message = "年龄不可以大于100岁")
    @Min(value = 18,message = "年龄不可以小于18岁")
    private int age;

    @NotNull
    @Column(name = "dept_id")
    private Long deptId;
}
