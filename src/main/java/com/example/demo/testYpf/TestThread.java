package com.example.demo.testYpf;

 class RunnableDemo implements Runnable {

    private Thread thread;
    private String threadName;

    public RunnableDemo(String threadName) {
        System.out.println("Create:::"+threadName);
        this.threadName = threadName;
    }

    @Override
    public void run() {
        System.out.println("Running:::"+threadName);
        for (int i=0;i<4;i++){
            try{
                    System.out.println("Thread ：：："+ threadName+"::"+i+" is running");
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                System.out.println("Thread ：：："+ i+" is Interrupted");
            }
        }
        System.out.println("Thread:::"+threadName+" exits");
    }

    public void start(){
        if (thread==null){
            thread = new Thread(this,threadName);
            thread.start();
        }
    }

}

public class TestThread{
    public static void main(String[] args) {
        RunnableDemo runnableDemo = new RunnableDemo("线程一");
        runnableDemo.start();
        RunnableDemo runnableDemo1 = new RunnableDemo("线程二");
        runnableDemo1.start();
    }
}

