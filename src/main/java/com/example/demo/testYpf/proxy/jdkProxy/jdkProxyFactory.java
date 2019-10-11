package com.example.demo.testYpf.proxy.jdkProxy;

import com.example.demo.testYpf.EatingImpl;
import com.example.demo.testYpf.interfaceTest.Eatting;

import java.lang.reflect.Proxy;

public class jdkProxyFactory {
    public static void main(String[] args) {
        Eatting eatting = jdkProxyFactory.getProxyObject(EatingImpl.class);
        eatting.eat();
    }

    public static <T> T getProxyObject(Class clazz){
        Aop aop = null;
       try{
           aop = new Aop(clazz.newInstance());
           T proxy =(T) Proxy.newProxyInstance(jdkProxyFactory.class.getClassLoader(),clazz.getInterfaces(),aop);
           return proxy;
       }catch (Exception e){
           e.printStackTrace();
       }
          return null;
    }
}
