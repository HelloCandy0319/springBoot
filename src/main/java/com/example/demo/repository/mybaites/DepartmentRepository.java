package com.example.demo.repository.mybaites;

import com.example.demo.dto.DeptDto;
import com.example.demo.entity.mybaites.Department;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface DepartmentRepository {

    @Select("select * from department")
    @Results({
            @Result(column = "dept_name",property = "deptName")
    })
    public List<Department> departmentList ();

    @Insert("INSERT INTO department(dept_name,parent_dept) VALUES (#{deptName},#{parentDept})")
    @Results({
            @Result(column = "dept_name",property = "deptName",jdbcType = JdbcType.VARCHAR),
            @Result(column = "parent_dept",property = "parentDept",jdbcType = JdbcType.NUMERIC)
    })
     void saveDept(Department department);

    @Select("select * from department where id = #{id}")
     Department getDept(Long id);

    @Select("SELECT d.`id` AS deptId,d.`parent_dept` AS parentDept,d.`dept_name` AS deptName,e.`employee_name` AS empName," +
            "e.`id` AS empId FROM department d LEFT JOIN employee e ON d.`id` = e.`dept_id`;")
    List<DeptDto> deptToEmp();

}
