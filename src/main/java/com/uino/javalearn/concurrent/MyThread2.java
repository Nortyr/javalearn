package com.uino.javalearn.concurrent;

public class MyThread2 extends Thread {
    MyThread2(Runnable runnable){
        super(runnable);
    }
    public void run() {
        System.out.println("Thread..."+Thread.currentThread().getName());
    }
}
