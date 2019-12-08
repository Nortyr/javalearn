package com.uino.javalearn.concurrent.test5;

public class ThreadLife {
    public static void main(String[] args) {
        test2();
    }

    private static void test3() {
        Thread t=new Thread(()->{
            synchronized ("123"){
                try {
                    "123".wait(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("hhhh1");
            }
        });
        Thread t1=new Thread(()->{
            synchronized ("123"){

                System.out.println("hhhh2");
                while (true){}
            }
        });
        System.out.println("t..."+t.getState());
        System.out.println("t1..."+t1.getState());
        t.start();
        t1.start();
        while (true){
            System.out.println("t..."+t.getState());
            System.out.println("t1..."+t1.getState());
        }
    }

    private static void test2() {
        Thread t=new Thread(()->{
            synchronized ("123"){
                try {
                    "123".wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("hhhh1");
            }
        });
        Thread t1=new Thread(()->{
            synchronized ("123"){
                System.out.println("hhhh2");
            }
        });
        System.out.println("t..."+t.getState());
        System.out.println("t1..."+t1.getState());
        t.start();
        t1.start();
        while (true){
            System.out.println("t..."+t.getState());
            System.out.println("t1..."+t1.getState());
        }
    }

    private static void test1() {
        Thread t=new Thread(()->{
           synchronized ("123"){
               try {
                   Thread.sleep(1);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               System.out.println("hhhh1");
           }
        });
        Thread t1=new Thread(()->{
            synchronized ("123"){
                System.out.println("hhhh2");
            }
        });
        System.out.println("t..."+t.getState());
        System.out.println("t1..."+t1.getState());
        t.start();
        t1.start();
        while (true){
            System.out.println("t..."+t.getState());
            System.out.println("t1..."+t1.getState());
        }

    }
}
