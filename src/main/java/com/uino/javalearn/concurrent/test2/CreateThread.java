package com.uino.javalearn.concurrent.test2;

public class CreateThread {
    /**
     *计数器
     */
    private static int num=0;
    public static void main(String[] args) {
        testConcurrent6();
    }

    private static void testConcurrent6() {
        MyThread5 t=new MyThread5();
        Thread a=new Thread(t);
        Thread b=new Thread(t);
        Thread c=new Thread(t);
        Thread d=new Thread(t);
        Thread e=new Thread(t);

        a.start();
        b.start();
        c.start();
        d.start();
        e.start();
    }

    private static void testConcurrent5() {
        MyThread4 a=new MyThread4("A");
        MyThread4 b=new MyThread4("B");
        MyThread4 c=new MyThread4("C");
        a.start();
        b.start();
        c.start();

    }
    private static void testConcurrent4() {
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                for (int j = 0; j < 100; j++) {
                    inCreate();
                }
            }).start();
        }
        System.out.println(num);

    }

    private static void testConcurrent3() {
        Runnable r=new MyThread3();
        Thread t=new Thread(r);
        Thread t1=new Thread(r);
        t.start();
        t1.start();
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
    /**
     *静态方法，直接对num计数器进行++操作。
     */
    public static void inCreate(){
        num++;
    }
}
