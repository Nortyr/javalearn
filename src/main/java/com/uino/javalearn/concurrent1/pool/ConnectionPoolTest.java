package com.uino.javalearn.concurrent1.pool;

import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class ConnectionPoolTest {
    static ConnectionPool pool = new ConnectionPool(10);
    // CountDownLatch
    static CountDownLatch start = new CountDownLatch(1);
    static CountDownLatch end;

    public static void main(String[] args) throws InterruptedException {
        int threadCount = 100;
        end = new CountDownLatch(threadCount);
        int count = 20;
        AtomicInteger got = new AtomicInteger();
        AtomicInteger notGot = new AtomicInteger();
        for (int i = 0; i < threadCount; i++) {
            Thread thread = new Thread(new ConnectionRunner(count,got,notGot),"ConnectionRunnerThread");
            thread.start();
        }
        start.countDown();
        end.await();
        System.out.println("total invoke:"+(threadCount*count));
        System.out.println("got connection"+got);
        System.out.println("not got connection"+notGot);
    }

    static class ConnectionRunner implements Runnable {
        int count;
        AtomicInteger got;
        AtomicInteger notGot;

        ConnectionRunner(int count, AtomicInteger got, AtomicInteger notGot) {
            this.count = count;
            this.got = got;
            this.notGot = notGot;
        }

        @Override
        public void run() {
            try {
                start.await();
            } catch (Exception e) {
            }
            while (count > 0) {
                try {
                    try {
                        //获取连接
                        Connection connection = pool.fetchConnection(1000);
                        if (connection != null) {
                            try {
                                //操作
                                connection.createStatement();
                                connection.commit();
                            } finally {
                                //归还连接
                                pool.releaseConnection(connection);
                                got.incrementAndGet();
                            }
                        }
                    } catch (InterruptedException | SQLException e) {
                        e.printStackTrace();
                    } finally {
                        count--;
                    }
                } catch (Exception e) {
                }

            }
            end.countDown();
        }
    }
}
