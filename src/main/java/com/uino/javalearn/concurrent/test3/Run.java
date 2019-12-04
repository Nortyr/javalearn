package com.uino.javalearn.concurrent.test3;

public class Run {
    public static void main(String[] args) {
        test8();
    }

    /**
    * @author 陈晖
    * @description :xxx.class和Class.forName("")等效
    * @date 17:14 2019/12/4
    * @param []
    * @return void
    */
    private static void test8() {
        MyService myService=new Myservice7();
        MyService myService1=new Myservice7();
        Runnable myThread1=new MyThread1(myService);
        Runnable myThread2=new MyThread2(myService1);
        Thread t1=new Thread(myThread1);
        Thread t2=new Thread(myThread2);
        t1.start();
        t2.start();
    }

    /**
    * @author 陈晖
    * @description :synchronized(this)和synchronized void等效
    * @date 15:44 2019/12/4
    * @param
    * @return void
    */
    private static void test7() {
        MyService myService=new Myservice6();
        MyService myService1=new Myservice6();
        Runnable myThread1=new MyThread1(myService);
        Runnable myThread2=new MyThread2(myService);
        Thread t1=new Thread(myThread1);
        Thread t2=new Thread(myThread2);
        t1.start();
        t2.start();
    }

    /**
    * @author 陈晖
    * @description :static synchronized和synchronized(xxx.class)等效
    * @date 15:38 2019/12/4
    * @param
    * @return void
    */
    private static void test6() {
        Myservice5 myService=new Myservice5();
        Myservice5 myService1=new Myservice5();
        Thread t1=new Thread(()->{
            myService.task1();
        });

        Thread t2=new Thread(()->{
            myService1.task2();
        });
        t1.start();
        t2.start();
    }

    //同步代码块锁 class
    private static void test5() {
        MyService myService=new Myservice4();
        MyService myService1=new Myservice4();
        Runnable myThread1=new MyThread1(myService);
        Runnable myThread2=new MyThread2(myService1);
        Thread t1=new Thread(myThread1);
        Thread t2=new Thread(myThread2);
        t1.start();
        t2.start();
    }

    //同步代码块锁this
    private static void test4() {
        MyService myService=new MyService3();
        MyService myService1=new MyService3();
        Runnable myThread1=new MyThread1(myService);
        Runnable myThread2=new MyThread2(myService1);
        Thread t1=new Thread(myThread1);
        Thread t2=new Thread(myThread2);
        t1.start();
        t2.start();
    }

    //静态方法锁，锁的是当前类的对象
    private static void test3() {
        MyService3 myService1=new MyService3();
        MyService3 myService2=new MyService3();
        Runnable r1 = ()->{
            myService1.task1();
        };
        Runnable r2 = ()->{
            myService2.task2();
        };
        Thread t1=new Thread(r1);
        Thread t2=new Thread(r2);
        t1.start();
        t2.start();
    }

    //方法锁，锁住的是当前对象
    private static void test2() {
        MyService myService=new MyService2();
        MyService myService1=new MyService2();

        Runnable myThread1=new MyThread1(myService);
//        Runnable myThread2=new MyThread2(myService);
        Runnable myThread2=new MyThread2(myService1);

        Thread t1=new Thread(myThread1);
        Thread t2=new Thread(myThread2);
        t1.start();
        t2.start();
    }

    private static void test1() {
        MyService myService=new MyService1();
        Runnable myThread1=new MyThread1(myService);
        Runnable myThread2=new MyThread2(myService);
        Thread t1=new Thread(myThread1);
        Thread t2=new Thread(myThread2);
        t1.start();
        t2.start();
    }
}
