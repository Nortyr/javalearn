package com.uino.javalearn.concurrent.test4;

/**
* @author 陈晖
* @description :同步代码快锁当前对象
* @date 15:28 2019/12/4
* @param
* @return
*/
public class MyService3 implements MyService{

    public void task1() {
        synchronized (this){
            while (true){
                System.out.println("task1"+Thread.currentThread().getName());
            }
        }
    }

    public  void task2() {
        synchronized (this){
            while (true) {
                System.out.println("task2" + Thread.currentThread().getName());
            }
        }

    }
}
