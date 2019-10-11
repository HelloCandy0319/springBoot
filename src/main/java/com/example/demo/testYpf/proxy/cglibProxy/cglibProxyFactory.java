package com.example.demo.testYpf.proxy.cglibProxy;

import com.example.demo.testYpf.EatingImpl;
import com.example.demo.testYpf.interfaceTest.Eatting;
import org.springframework.cglib.proxy.Enhancer;

public class cglibProxyFactory {
    public static void main(String[] args) {
        Eatting eatting = cglibProxyFactory.getProxyObject(EatingImpl.class);
        eatting.eat();
    }

    public static <T>T getProxyObject(Class clazz){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(new Aop());
        T result = (T)enhancer.create();
        return result;
    }

}
