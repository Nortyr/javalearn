package com.uino.javalearn.concurrent.test4;

public class P {
    private String lock;
    public P(String lock){
        super();
        this.lock=lock;
    }
    public void setValue(){
        try {
            synchronized (lock){
                if(!ValueObject.value.equals("")){
                    lock.wait();
                }
                String value=System.currentTimeMillis()+"_"+System.nanoTime();
                System.out.println("set的值"+value);
                ValueObject.value=value;
                lock.notify();
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
