package com.uino.javalearn.concurrent1.pool;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch=new CountDownLatch(3);
        for(int i=0;i<100;i++){
            Thread t=new Thread(()->{
                try{
                    System.out.println("thread start:--"+Thread.currentThread().getName());
                    Thread.sleep(100);
                    System.out.println(latch.toString());
                    System.out.println("thread end:--"+Thread.currentThread().getName());

                }catch (Exception e){

                }finally {
                    latch.countDown();
                }
            });
            t.start();
        }
        System.out.println("main await");

        latch.await();
        System.out.println("main end");
    }
}
