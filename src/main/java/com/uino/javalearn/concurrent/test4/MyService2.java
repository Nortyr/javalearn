package com.uino.javalearn.concurrent.test4;

/**
* @author 陈晖
* @description :同步方法
* @date 15:28 2019/12/4
* @param
* @return
*/
public class MyService2 implements MyService {
    @Override
    public synchronized void task1() {
        while (true){
            System.out.println("task1"+Thread.currentThread().getName());
        }
    }

    @Override
    public synchronized void task2() {
        while (true) {
            System.out.println("task2" + Thread.currentThread().getName());
        }
    }
}
