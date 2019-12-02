package com.uino.javalearn.concurrent;

public class MyThread1 implements Runnable {
    @Override
    public void run() {
        System.out.println("Runnable..."+Thread.currentThread().getName());
    }
}
