package com.uino.javalearn.concurrent.test2;

public class CreateThread {
    public static void main(String[] args) {
        testConcurrent2();
    }
    
    /**
    * @author 陈晖
    * @description :这下2个线程的run锁的是一个对象了，只有一个线程能循环
    * @date 16:38 2019/12/2
    * @param []
    * @return void
    */
    private static void testConcurrent2() {
        Runnable r=new MyThread2();
        Thread t=new Thread(r);
        Thread t1=new Thread(r);
        t.start();
        t1.start();
    }
    /**
    * @author 陈晖
    * @description :没有通过实现runnable接口，synchronized锁的是2个对象
    * @date 16:36 2019/12/2
    * @param []
    * @return void
    */
    private static void testConcurrent1() {
        Thread myThread=new MyThread1();
        Thread myThread1=new MyThread1();
        myThread.start();
        myThread1.start();
    }

    /**
    * @author 陈晖
    * @description :测试继承Thread类
    * @date 15:59 2019/12/2
    * @return void
    */
    private static void testConcurrent() {
        Thread myThread=new MyThread();
        Thread myThread1=new MyThread();
        myThread.start();
        myThread1.start();
    }
}
