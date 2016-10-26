package com.myjava.thread.base;

/*
 * 同步函数
 *
 * 同步函数和同步代码块的区别：
        同步函数的锁是固定的this。
        同步代码块的锁是任意的对象。
        建议使用同步代码块。
 */
public class SynFunctionLockDemo {

    public static void main(String[] args) {
        Tickets t = new Tickets(); // 创建一个线程任务对象
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
class Tickets implements Runnable { // 使用实现接口
    private int num = 100;
    boolean flag = true;
    Object obj = new Object();

    @Override
    public void run() {
        if (flag) {
            while (true) {
                synchronized (this) { // 线程的锁对象，必须相同
                    if (num > 0) {
                        try {
                            Thread.sleep(10); // 能看出线程不同步导致的问题
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName() + "...obj..." + num--);
                    }
                }
            }
        } else {
            while (true) {
                this.show(); // 需要加this
            }
        }
    }

    public synchronized void show() {
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
