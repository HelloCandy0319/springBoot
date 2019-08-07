package com.example.demo.dto;

import com.example.demo.entity.mybaites.Employee;
import lombok.Data;

import java.util.List;

@Data
public class DeptDto {
    private String deptName;
    private Long deptId;
   private String empName;
   private Long empId;
   private Long parentDept;
}
