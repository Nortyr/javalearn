package com.uino.javalearn.concurrent.test1;

public class MyThread1 implements Runnable {
    @Override
    public void run() {
        System.out.println("Runnable..."+Thread.currentThread().getName());
    }
}
