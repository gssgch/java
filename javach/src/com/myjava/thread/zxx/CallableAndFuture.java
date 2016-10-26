package com.myjava.thread.zxx;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Date: Aug 13, 2015 10:45:20 PM   Author: ch
 * callable和future的应用
 */
public class CallableAndFuture {

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newSingleThreadExecutor();
        // 能拿到线程的结果  Future对象
        Future<String> future = threadPool.submit(new Callable<String>() {

            @Override
            public String call() throws Exception {
                Thread.sleep(2000);
                return "hello world";
            }
        });
        System.out.println("等待结果");
        try {
            System.out.println("拿到结果：" + future.get());
            // 1秒之内拿到结果，拿不到  抛异常
            //            System.out.println("拿到结果：" + future.get(1, TimeUnit.SECONDS));
        } catch (Exception e) {
        }

        ExecutorService threadPool2 = Executors.newFixedThreadPool(10);
        CompletionService<Integer> completionService = new ExecutorCompletionService<Integer>(threadPool2);

        for (int j = 0; j <= 10; j++) {
            final int seq = j;
            completionService.submit(new Callable<Integer>() {

                @Override
                public Integer call() throws Exception {
                    Thread.sleep(new Random().nextInt(5000));
                    return seq;
                }
            });
        }

        for (int i = 0; i < 10; i++) {
            try {
                System.out.println(completionService.take().get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

    }
}
