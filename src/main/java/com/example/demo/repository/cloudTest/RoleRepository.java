package com.example.demo.repository.cloudTest;

import com.example.demo.entity.cloudTest.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RoleRepository extends JpaRepository<Role,Long>, JpaSpecificationExecutor<Role> {
}
