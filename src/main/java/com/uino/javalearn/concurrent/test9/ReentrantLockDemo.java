package com.uino.javalearn.concurrent.test9;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantLockDemo {
    public static void main(String[] args) {
        test4();
    }

    private static void test4() {
        Lock t1=new ReentrantLock();
        Lock t2=new ReentrantLock();

        Condition c1=t1.newCondition();
        Condition c2=t1.newCondition();
        AtomicBoolean hasValue= new AtomicBoolean(false);

        Thread thread1=new Thread(()->{
            try{
                t1.lock();
                while(hasValue.get() ==true){
                    c1.await();
                }
                System.out.println("set()");
                hasValue.set(true);
                c1.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("11111 end");
                t1.unlock();
            }
        });
        Thread thread2=new Thread(()->{
            try{
                t1.lock();
                while(hasValue.get() ==false){
                    c1.await();
                }
                System.out.println("get()");
                hasValue.set(false);
                c1.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("22222 end");

                t1.unlock();
            }
        });
        thread1.start();
        thread2.start();
    }

    private static void test3() {
        ReentrantReadWriteLock t1=new ReentrantReadWriteLock();
        Lock l1= t1.readLock();
        Lock l2=t1.writeLock();
        Thread thread1=new Thread(()->{
            try{
                l1.lock();
                for (;;) {
                    System.out.println(111111);
                }
            }finally {
                l1.unlock();
            }
        });
        Thread thread2=new Thread(()->{
            try{
                l2.lock();
                for (;;) {
                    System.out.println(222222);
                }
            }finally {
                l2.unlock();
            }
        });
        Thread thread3=new Thread(()->{
            try{
                l1.lock();
                for (;;) {
                    System.out.println(222222);
                }
            }finally {
                l1.unlock();
            }
        });
        thread1.start();
        thread2.start();
        thread3.start();

    }

    //写锁
    private static void test2() {
        ReentrantReadWriteLock t1=new ReentrantReadWriteLock();
        Lock l1= t1.readLock();
        Lock l2=t1.writeLock();
        Thread thread1=new Thread(()->{
            try{
                l2.lock();
                for (;;) {
                    System.out.println(111111);
                }
            }finally {
                l2.unlock();
            }
        });
        Thread thread2=new Thread(()->{
            try{
                l2.lock();
                for (;;) {
                    System.out.println(222222);
                }
            }finally {
                l2.unlock();
            }
        });
        thread1.start();
        thread2.start();
    }

    // 2个读锁
    private static void test1() {
        ReentrantReadWriteLock t1=new ReentrantReadWriteLock();
        Lock l1= t1.readLock();
        Lock l2=t1.writeLock();
        Thread thread1=new Thread(()->{
           try{
               l1.lock();
               for (;;) {
                   System.out.println(111111);
               }
           }finally {
               l1.unlock();
           }
        });
        Thread thread2=new Thread(()->{
            try{
                l1.lock();
                for (;;) {
                    System.out.println(222222);
                }
            }finally {
                l1.unlock();
            }
        });
        thread1.start();
        thread2.start();
    }
}
