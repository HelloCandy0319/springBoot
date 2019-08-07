package com.example.demo.repository.mybaites.provider;

import org.apache.ibatis.annotations.Select;

public class EmployeeSqlProvider {

    public String selectEmployee(Long empId){
       return "select id,employee_name,age from employee where id = "+empId;

    }
}
