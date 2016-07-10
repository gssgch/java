package com.thread.zxx;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Date: Aug 8, 2015 1:27:12 PM   Author: ch
 * 线程范围内共享变量的概念与作用
 */
public class ThreadScopeShareData {

    private static int data = 0;
    private static Map<Thread, Integer> threadData = new HashMap<Thread, Integer>();

    public static void main(String[] args) {

        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int data = new Random().nextInt();
                    System.out.println(Thread.currentThread().getName() + " has put data :" + data);
                    threadData.put(Thread.currentThread(), data);
                    new A().get();
                    new B().get();
                }
            }).start();
        }
    }

    static class A {
        private void get() {
            int data = threadData.get(Thread.currentThread());
            System.out.println("A-" + Thread.currentThread().getName() + " get data :" + data);
        }
    }

    static class B {
        private void get() {
            int data = threadData.get(Thread.currentThread());
            System.out.println("B-" + Thread.currentThread().getName() + " get data :" + data);
        }
    }
}
