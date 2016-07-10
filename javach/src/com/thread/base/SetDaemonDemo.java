package com.thread.base;

/* 守护线程   setDaemo
 *也叫后台线程，如果前台线程都结束了，无论后台线程状态如何，都自动消失。
 *
 */
public class SetDaemonDemo {

    public static void main(String[] args) {
        StopThread2 st = new StopThread2();
        Thread t1 = new Thread(st);
        Thread t2 = new Thread(st);
        t1.start();
        t2.setDaemon(true); // 设置为守护线程   后台线程
        t2.start();
        int num = 1;
        for (;;) {
            if (++num == 50) {
                t1.interrupt(); // 此处不需要改变t2的状态
                break;
            }
            System.out.println("...main" + num);
        }
        System.out.println("over");
    }

}

class StopThread2 implements Runnable {
    private boolean flag = true;

    @Override
    public synchronized void run() {
        while (flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + "..." + e);
                flag = false;
            }
            System.out.println(Thread.currentThread().getName() + "............");
        }
    }

    public void setFlag() {
        flag = false;
    }
}