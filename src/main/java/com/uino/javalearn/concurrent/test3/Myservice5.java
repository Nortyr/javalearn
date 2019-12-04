package com.uino.javalearn.concurrent.test3;

/**
* @author 陈晖
* @description :同步代码快锁.class
* @date 15:27 2019/12/4
* @param
* @return
*/
public class Myservice5 implements MyService{
    public void task1() {
        synchronized (Myservice5.class){
            while (true){
                System.out.println("task1"+Thread.currentThread().getName());
            }
        }
    }

    public  void task2() {
        synchronized (Myservice5.class) {
            while (true) {
                System.out.println("task2" + Thread.currentThread().getName());
            }
        }
    }
}
