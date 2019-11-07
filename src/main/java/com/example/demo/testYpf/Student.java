package com.example.demo.testYpf;

import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Student extends Teacher {
    private String name = "张三";

    public Student() {
        super();
        System.out.println("I am student");
    }

    @Override
    public void printf() {
        System.out.println("I am Student Printf");
        class inner{
            String names;
            public void printfInner(){
                System.out.println(name);
            }
        }

    }

    public static void test(int i){
        i = i+1;
    }

    public static void main(String[] args) {
        Teacher teacher = new Student();
        int i=0;
        test(i);
        System.out.println(i++);
        System.out.println(++i);
        teacher.printf();
//        ConcurrentLinkedQueue
//        LinkedBlockingQueue
//        ConcurrentHashMap
    }
}
