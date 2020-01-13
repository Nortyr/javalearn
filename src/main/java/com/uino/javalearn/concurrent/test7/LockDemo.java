package com.uino.javalearn.concurrent.test7;

public class LockDemo {
    public static void main(String[] args) {
       test2();
    }

    private static void test2() {
        MyService1 myService=new MyService1();
        Thread t1=new Thread(()->{
            try {
                myService.testMethod();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2=new Thread(()->{
            try {
                myService.testMethod();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t3=new Thread(()->{
            try {
                myService.testMethod();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t4=new Thread(()->{
            try {
                myService.testMethod();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t5=new Thread(()->{
            try {
                myService.testMethod();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }

    private static void test1() {
        MyService myService=new MyService();
        Thread t1=new Thread(()->{
            myService.testMethod();
        });
        Thread t2=new Thread(()->{
            myService.testMethod();
        });
        Thread t3=new Thread(()->{
            myService.testMethod();
        });
        Thread t4=new Thread(()->{
            myService.testMethod();
        });
        Thread t5=new Thread(()->{
            myService.testMethod();
        });
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
