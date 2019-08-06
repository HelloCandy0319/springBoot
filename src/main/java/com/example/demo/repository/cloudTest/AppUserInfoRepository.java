package com.example.demo.repository.cloudTest;

import com.example.demo.entity.cloudTest.AppUserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AppUserInfoRepository extends JpaRepository<AppUserInfo,String>, JpaSpecificationExecutor<AppUserInfo> {
}
