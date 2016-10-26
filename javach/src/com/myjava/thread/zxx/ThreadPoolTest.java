package com.myjava.thread.zxx;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Date: Aug 13, 2015 9:36:32 PM   Author: ch
 * 线程池
 */
public class ThreadPoolTest {

    // 池子里有3个线程，有多个任务，但是每次只有有限个数的任务被线程池里的线程消费
    public static void main(String[] args) {
        // 固定数量的线程池
        //        ExecutorService threadPool = Executors.newFixedThreadPool(3); // 创建3个线程
        //        ExecutorService threadPool = Executors.newCachedThreadPool(); // 可变数量线程池
        // 单线程保证     可实现线程死掉后重新启动
        ExecutorService threadPool = Executors.newSingleThreadExecutor(); // 单个线程，线程死掉后就新创建
        for (int j = 1; j <= 10; j++) {
            final int task = j;
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j <= 10; j++) {
                        try {
                            Thread.sleep(20);
                        } catch (InterruptedException e) {
                        }
                        System.out.println(Thread.currentThread().getName() + " is looping of " + j + " for task of " + task);
                    }
                }
            });
        }
        System.out.println("all of 10 tasks have committed!");
        // 结束线程
        //        threadPool.shutdown();
        //        threadPool.shutdownNow(); // 立即干掉线程

        // 线程池的定时任务调度
        Executors.newScheduledThreadPool(3).schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("bombing!!!");
            }
        }, 5, TimeUnit.SECONDS);

        // 5秒后   然后每隔几秒
        Executors.newScheduledThreadPool(3).scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("--bombing!!!");
            }
        }, 5, 2, TimeUnit.SECONDS);
    }
}
