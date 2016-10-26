package com.myjava.thread.zxx;

/**
 * Date: Aug 9, 2015 10:05:47 PM   Author: ch
 * 多个线程之间共享数据的方式探讨
 */
public class MultiThreadShareData {
    private static ShareData1 data1 = new ShareData1();

    public static void main(String[] args) {

        // 可以在这里定义，也可以在外部用private static修饰
        final ShareData1 data1 = new ShareData1();
        ShareData1 data2 = new ShareData1();

        // 这是另一种方式
        new Thread(new MyRunnable1(data2)).start();
        new Thread(new MyRunnable2(data2)).start();

        // 这是一种方式
        new Thread(new Runnable() {
            @Override
            public void run() {
                data1.decrement();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                data1.increment();
            }
        }).start();
    }
}

class MyRunnable1 implements Runnable {

    private ShareData1 data1;

    public MyRunnable1(ShareData1 data1) {
        this.data1 = data1;
    }

    @Override
    public void run() {

    }
}

class MyRunnable2 implements Runnable {

    private ShareData1 data1;

    public MyRunnable2(ShareData1 data1) {
        this.data1 = data1;
    }

    @Override
    public void run() {

    }
}

class ShareData1 /*implements Runnable*/{
    private int count = 100;

    /* @Override // 买票可以使用这种方式，因为是一个对象，而且只有递减的
         public void run() {
             while (true) {
                 count--;
             }
         }*/

    private int j = 0;

    public synchronized void increment() {
        j++;
    }

    public synchronized void decrement() {
        j--;
    }
}
