package com.uino.javalearn.concurrent.test4;

/**
* @author 陈晖
* @description :同步代码快锁.class
* @date 15:27 2019/12/4
* @param
* @return
*/
public class Myservice6 implements MyService {
    public void task1() {
        synchronized (this){
            while (true){
                System.out.println("task1"+Thread.currentThread().getName());
            }
        }
    }

    public  synchronized void task2() {

            while (true) {
                System.out.println("task2" + Thread.currentThread().getName());
            }


    }
}
