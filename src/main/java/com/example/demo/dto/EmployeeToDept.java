package com.example.demo.dto;

import lombok.Data;

@Data
public class EmployeeToDept {
    private String employeeName;

    private Long employeeId;

    private Long deptId;

    private String deptName;
}
