package com.uino.javalearn.concurrent.test2;

public class MyThread extends Thread {

    public void run() {
        int sum=0;
        for(int i=0;i<100000;i++){
            sum+=i;
//            System.out.println("Thread..."+Thread.currentThread().getName());
        }
        System.out.println(sum);
    }
}
