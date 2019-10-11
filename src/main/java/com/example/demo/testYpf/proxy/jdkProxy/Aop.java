package com.example.demo.testYpf.proxy.jdkProxy;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class Aop implements InvocationHandler {


    Object target;

    public Aop() {
    }

    public Aop(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("java proxy before:jdk 动态代理前");
        Object object = method.invoke(target,args);
        System.out.println("java proxy after：jdk 动态代理后");
        return object;
    }
}
