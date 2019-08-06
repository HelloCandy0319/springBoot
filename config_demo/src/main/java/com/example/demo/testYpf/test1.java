package com.example.demo.testYpf;

import com.example.demo.testYpf.interfaceTest.test2;

public class test1 extends test2 {

    public void testStatic(){
        test.testStatic();
    }

    public  void testStatic1(){
        int res = 5+2;
        System.out.println(res);
    }

    @Override
    public void testExtend() {

        System.out.println("test2");
    }
}
