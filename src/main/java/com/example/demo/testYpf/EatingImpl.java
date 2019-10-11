package com.example.demo.testYpf;

import com.example.demo.testYpf.interfaceTest.Eatting;

public class EatingImpl implements Eatting {

    @Override
    public void eat() {
        System.out.println("饿了，该吃饭啦！小猪佩奇");
    }
}
