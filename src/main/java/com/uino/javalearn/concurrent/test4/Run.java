package com.uino.javalearn.concurrent.test4;

public class Run {
    volatile public static boolean flag=false;
    private static Object o=new Object();
    private static Object o1=new Object();

    public static void main(String[] args) {
        test2();
    }

    private static void test2() {
    }


    private static void test1() {
        Thread thread=new Thread(()->{
            synchronized ("123"){
                while(true){
                    if(!flag){
                        System.out.println(flag);
                        flag=true;
                    }

                }
            }
        });
        Thread thread1=new Thread(()->{
            synchronized ("234"){
                while(true){
                    if(flag){
                        System.out.println(flag);
                        flag=false;
                    }

                }
            }
        });
        thread.start();
        thread1.start();
    }
}
