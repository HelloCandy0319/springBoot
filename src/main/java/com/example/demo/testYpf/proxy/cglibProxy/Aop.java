package com.example.demo.testYpf.proxy.cglibProxy;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class Aop implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib：动态代理前");
        Object result = methodProxy.invokeSuper(o,objects);
        System.out.println("cglib：动态代理后");
        return result;
    }
}
