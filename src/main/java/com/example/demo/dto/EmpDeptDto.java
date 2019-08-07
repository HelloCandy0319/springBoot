package com.example.demo.dto;

import com.example.demo.entity.mybaites.Employee;
import lombok.Data;

import java.util.List;

@Data
public class EmpDeptDto {
    private Long deptId;

    private Long parentDept;

    private String deptName;

   private List<DeptDto> deptDtos;

}
