package com.uino.javalearn.concurrent.test2;

public class MyThread3 implements Runnable {
    public static int sum;

    @Override
    public void run() {

        for(int i=0;i<1000;i++){
            sum+=i;

        }
        System.out.println(sum);
    }
}
