package com.thread.base;

// 面试题
public class ThreadTest {

    public static void main(String[] args) {

        new Thread(new Runnable() { // 任务
            @Override
            public void run() {
                System.out.println("runnable run");
            }
        }) {
            @Override
            public void run() { // 子类
                System.out.println("subThread run");
            }

        }.start();

        //        new Thread() {
        //            @Override
        //            public void run() {
        //                for (int x = 0; x < 50; x++) {
        //                    System.out.println(Thread.currentThread().getName() + "...x=" + x);
        //                }
        //            }
        //        }.start();
        //
        //        for (int x = 0; x < 50; x++) {
        //            System.out.println(Thread.currentThread().getName() + "...y=" + x);
        //        }
        //
        //        Runnable r = new Runnable() {
        //            @Override
        //            public void run() {
        //                for (int x = 0; x < 50; x++) {
        //                    System.out.println(Thread.currentThread().getName() + "...z=" + x);
        //                }
        //            }
        //
        //        };
        //        new Thread(r).start();
    }
}

// 下面这个类是否有错误，

//class Test implements Runnable {
//    public void run(Thread t) {
//
//    }
//}

// 错误在第一行，应该被abstract修饰