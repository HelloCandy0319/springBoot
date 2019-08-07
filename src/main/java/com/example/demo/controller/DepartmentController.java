package com.example.demo.controller;

import com.example.demo.dto.DeptDto;
import com.example.demo.dto.EmpDeptDto;
import com.example.demo.dto.ParentDeptDto;
import com.example.demo.entity.mybaites.Department;
import com.example.demo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/dept")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/")
    public List<Department> departmentList(){
        return departmentService.departmentList();
    }

    @PostMapping("/")
    public void saveDept(Department department){
        departmentService.saveDept(department);
    }

    @GetMapping("/employee")
    public List<ParentDeptDto> deptToEmp(){
        return departmentService.deptDtoList();
    }
}
