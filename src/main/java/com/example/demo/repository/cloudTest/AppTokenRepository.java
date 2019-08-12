package com.example.demo.repository.cloudTest;

import com.example.demo.entity.cloudTest.AppToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AppTokenRepository extends JpaRepository<AppToken,Long>, JpaSpecificationExecutor<AppToken> {
    public AppToken findByAppId(String appId);
    public AppToken findFirstByToken(String token);
}
