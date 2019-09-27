package com.example.demo.testYpf.interfaceTest;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class TestThread implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        int i = 0;
        for (i=0;i<5;i++){
            System.out.println("线程执行"+i);
        }
        return i;
    }

    public static void main(String[] args) {
        TestThread testThread = new TestThread();
        FutureTask<Integer> futureTask = new FutureTask<>(testThread);
        for (int i=0;i<10;i++){
            System.out.println("循环线程：：："+i);
           try{
               Thread.sleep(1000);
           }catch (Exception e){
               e.printStackTrace();
           }
            if (i==4){
                new Thread(futureTask,"返回值的线程").start();
            }
        }
        try{
            System.out.println("子线程是：："+futureTask.get());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

