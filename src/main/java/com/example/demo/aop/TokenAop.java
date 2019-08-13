package com.example.demo.aop;

import com.example.demo.entity.cloudTest.AppToken;
import com.example.demo.repository.cloudTest.AppTokenRepository;
import com.example.demo.validator.field.UserIdInfo;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TokenAop {
    @Autowired
    private AppTokenRepository appTokenRepository;

    @Pointcut(value = "@annotation(userIdInfo)")
    public Long service(UserIdInfo userIdInfo){
        String token = userIdInfo.userId();
        AppToken appToken = appTokenRepository.findFirstByToken(token);
        if (appToken!=null){
            return appToken.getId();
        }else {
            return null;
        }

    }
}
