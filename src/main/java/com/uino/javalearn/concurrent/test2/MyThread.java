package com.uino.javalearn.concurrent.test2;

public class MyThread extends Thread {

    public void run() {
        while (true){
            System.out.println("Thread..."+Thread.currentThread().getName());
        }
    }
}
