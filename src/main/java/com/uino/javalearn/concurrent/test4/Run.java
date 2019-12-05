package com.uino.javalearn.concurrent.test4;

public class Run {
    volatile public static boolean flag=false;
    private static Object o=new Object();
    private static Object o1=new Object();

    public static void main(String[] args) {
        test3();
    }

    private static void test3() {
        String lock="";
        P p=new P(lock);
        C c=new C(lock);
        Thread t1=new Thread(()->{
            try {
                Thread.sleep(1000);
                p.setValue();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2=new Thread(()->{
                c.getValue();
        });
        t1.start();
        t2.start();
    }

    private static void test2() {
        String lock="";
        P p=new P(lock);
        C c=new C(lock);
        Thread t1=new Thread(()->{
            while (true){
                p.setValue();
            }
        });
        Thread t2=new Thread(()->{
            while (true){
                c.getValue();
            }
        });
        t1.start();
        t2.start();
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
