//package com.example.demo.aop;
//
//import com.alibaba.druid.support.spring.stat.DruidStatInterceptor;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.*;
//import org.springframework.stereotype.Component;
//
//@Aspect
//@Component
//public class springAop extends DruidStatInterceptor{
//
//    @Pointcut("bean(jdkRegexpMethodPointcut)") //声明一个切点
//    public void checkSpringDruid(){
//    }
//
////    @Before("checkSpringDruid()")
////    public void beforeSpringDruid(){
////        System.out.println("springAop 切面 切点之前使用");
////    }
////
////    @After("checkSpringDruid()")
////    public void afterSpringDruid(){
////        System.out.println("springAop 切面 切点之后使用");
////    }
//
//    @Around("checkSpringDruid()")
//    public Object doSpringDruid(ProceedingJoinPoint pjp) throws Throwable{
//        Object o =   pjp.proceed();
//        return o;
//    }
//
//}
//
