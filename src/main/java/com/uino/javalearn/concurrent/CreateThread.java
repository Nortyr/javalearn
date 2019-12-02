package com.uino.javalearn.concurrent;

public class CreateThread {
    public static void main(String[] args) {
        testConcurrent2();
    }

    private static void testConcurrent2() {
        Runnable thread=new MyThread1();
        Thread thread1=new MyThread2(thread);
        thread1.start();
    }

    /**
    * @author 陈晖
    * @description :实现runnable接口，通过Thread的
    * @date 16:01 2019/12/2
    * @return void
    */
    private static void testConcurrent1() {
        Runnable thread=new MyThread1();
        Thread thread1=new Thread(thread);
//        System.out.println(threa);
        thread1.start();
    }

    /**
    * @author 陈晖
    * @description :测试继承Thread类
    * @date 15:59 2019/12/2
    * @return void
    */
    private static void testConcurrent() {
        Thread myThread=new MyThread();
        myThread.start();
    }
}
