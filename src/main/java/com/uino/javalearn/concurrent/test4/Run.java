package com.uino.javalearn.concurrent.test4;

public class Run {
    volatile public static boolean flag=false;
    public static String b="bbb";
    private static Object o=new Object();
    private static Object o1=new Object();

    public static void main(String[] args) {
        test6();
    }

    private static void test6() {
        Thread t1=new Thread(()->{
            while (true){
                System.out.println("aaaaaa");
            }
        });
        Thread t2=new Thread(()->{
            while (true){
                System.out.println("bbbbbb");
            }
        });
        t1.start();
        t2.start();
    }

    private static void test5() {
        Thread thread=new Thread();
        thread.start();
        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void test4() {
        String lock="";
        Thread t1=new Thread(()->{
            synchronized (lock){

                try {
                    Thread.sleep(100000);
                    lock.wait();
                    System.out.println("it is wait");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });
        Thread t2=new Thread(()->{
            synchronized (lock){
                lock.notify();
                System.out.println("it is notify");
            }
        });
        t1.start();
        t2.start();
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
    private static void test33(){
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
    private static void test2() {

        String a=new String("aaa");
        Thread t=new Thread(()->{
            while (true){
                synchronized (a){
                    if(!b.equals("")){
                        try {
                            a.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        b="consumer";
                        a.notify();
                    }
                }
            }
        });
        Thread t1=new Thread(()->{
            while (true){
                synchronized (a){
                    if(b.equals("")){
                        try {
                            a.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        b="";
                        a.notify();
                    }
                }
            }
        });
        t.start();
        t1.start();
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
