package com.uino.javalearn.concurrent.test7;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyService1 {
    private Lock lock=new ReentrantLock();
    Condition condition=lock.newCondition();
    public void testMethod() throws InterruptedException {
        lock.lock();
        condition.await();
        lock.unlock();
    }
}
