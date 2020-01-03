package com.uino.javalearn.concurrent1.pool;

import java.sql.Connection;
import java.util.LinkedList;

public class ConnectionPool {
    private LinkedList<Connection> pool=new LinkedList<>();
    //连接池中创建多个链接
    public ConnectionPool(int initialSize){
        if(initialSize>0){
            for (int i = 0; i < initialSize; i++) {
                pool.addLast(ConnectionDriver.createConnection());
            }
        }
    }
    //放入一个连接
    public void releaseConnection(Connection connection){
        if(connection != null){
            pool.addLast(connection);
            pool.notifyAll();
        }
    }
    //返回一个连接
    public Connection fetchConnection(long mills)throws InterruptedException{
        synchronized (pool){
            //立即返回
            if(mills<=0){
                //返回第一个链接并移除
                while(pool.isEmpty()){
                    pool.wait();
                }
                return pool.removeFirst();
            }else{
                long future =System.currentTimeMillis()+mills;
                long remaining=mills;
                while(pool.isEmpty()&&remaining>0){
                    pool.wait(remaining);
                    remaining=future-System.currentTimeMillis();
                }
                Connection result=null;
                if(!pool.isEmpty()){
                    result=pool.removeFirst();
                }
                return result;
            }
        }
    }
}
