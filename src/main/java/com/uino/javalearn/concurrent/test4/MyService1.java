package com.uino.javalearn.concurrent.test4;

/**
* @author 陈晖
* @description :不加同步
* @date 15:28 2019/12/4
* @param
* @return
*/
public class MyService1 implements MyService {
    @Override
    public void task1() {
        while (true){
            System.out.println("task1"+Thread.currentThread().getName());
        }
    }

    @Override
    public void task2() {
        while (true) {
            System.out.println("task2" + Thread.currentThread().getName());
        }
    }
}
