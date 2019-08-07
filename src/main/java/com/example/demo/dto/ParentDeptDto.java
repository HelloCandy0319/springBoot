package com.example.demo.dto;

import lombok.Data;

import java.util.List;

@Data
public class ParentDeptDto {
    private Long deptId;

    private String deptName;

    private List<EmpDeptDto> childDept;

}
