package com.example.demo.entity.mybaites;

import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

@Data
public class Department {

    private Long id;

    @NotNull
    @Column(name = "dept_name")
    private String deptName;

    @Column(name = "parent_dept")
    private Long parentDept;
}
