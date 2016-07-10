package com.thread.base;

/*
 * 验证死锁   常见情景之一：同步的嵌套。
 */
public class DeadLockDemo {

    public static void main(String[] args) {
        Ticketes t = new Ticketes();
        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);
        t1.start(); // 走代码块
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.flag = false;
        t2.start(); // 走同步函数
    }

}

// 同步函数使用的锁是this
class Ticketes implements Runnable {
    private int num = 100;
    boolean flag = true;
    Object obj = new Object();

    @Override
    public void run() {
        if (flag) {
            while (true) {
                synchronized (obj) {
                    show();
                }
            }
        } else {
            while (true) {
                this.show();
            }
        }
    }

    public synchronized void show() {
        synchronized (obj) {
            if (num > 0) {
                try {
                    Thread.sleep(10); // 能看出线程不同步导致的问题
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "...function..." + num--);
            }
        }
    }
}
