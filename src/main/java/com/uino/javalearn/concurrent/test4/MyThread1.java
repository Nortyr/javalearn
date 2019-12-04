package com.uino.javalearn.concurrent.test4;

public class MyThread1 implements Runnable{
    MyService myService=null;
    MyThread1(MyService myService){
        this.myService=myService;
    }
    @Override
    public void run() {
        myService.task1();
    }
}
