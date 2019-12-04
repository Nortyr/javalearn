package com.uino.javalearn.concurrent.test4;

public class MyThread2 implements Runnable{
    MyService myService=null;
    MyThread2(MyService myService){
        this.myService=myService;
    }
    @Override
    public void run() {
        try {
            myService.task2();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
