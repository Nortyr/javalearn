package com.uino.javalearn.concurrent.test2;

public class MyThread2 extends Thread {

    public synchronized void run() {
        while (true){
            System.out.println("Thread..."+Thread.currentThread().getName());
        }
    }
}
