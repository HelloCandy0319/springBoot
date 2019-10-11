package com.example.demo.testYpf;

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

    public static void main(String[] args) {
        Teacher teacher = new Student();
        teacher.printf();
    }
}
