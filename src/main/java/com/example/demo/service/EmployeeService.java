package com.example.demo.service;

import com.example.demo.dto.EmployeeToDept;
import com.example.demo.entity.mybaites.Department;
import com.example.demo.entity.mybaites.Employee;
import com.example.demo.repository.mybaites.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentService departmentService;

    @Transactional
    public void save(Employee employee){
        Long deptId = employee.getDeptId();
        Department department = departmentService.getDept(deptId);
        if (department!=null){
            employeeRepository.save(employee);
        }else{
            System.out.println("部门不存在");
        }
    }

    public List<Employee> employees(){
        return employeeRepository.findAll();
    }

    public EmployeeToDept findEmployeeDept(Long id){
        return employeeRepository.findEmployeeToDept(id);
    }


}

