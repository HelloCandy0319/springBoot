package com.example.demo.aop;

import com.alibaba.fastjson.JSON;
import com.example.demo.entity.cloudTest.ErrorLog;
import com.example.demo.repository.cloudTest.ErrorLogRepository;
import com.example.demo.validator.method.Operation;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Aspect
@Component
public class ExceptionAop {
    private  final static Logger logger = LoggerFactory.getLogger(ExceptionAop.class);
    @Autowired
    private ErrorLogRepository errorLogRepository;

    @Pointcut(value = "@annotation(operation)")
    public void service(Operation operation){
    }

    @AfterThrowing(value = "service(operation)",throwing = "e")
    public void doAfterThrowing(Operation operation,Throwable e){
        ErrorLog errorLog = new ErrorLog();
        Date nowDate = new Date(System.currentTimeMillis());
        errorLog.setHappendTime(nowDate);
        errorLog.setExceptionJson(JSON.toJSONString(
                e.toString()
        ));
        errorLog.setMessage(e.getMessage());
        errorLogRepository.save(errorLog);
    }
}
