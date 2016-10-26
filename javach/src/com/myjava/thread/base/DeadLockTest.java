package com.myjava.thread.base;

/*
 * 验证死锁   常见情景之一：同步的嵌套。
 */
public class DeadLockTest {

    public static void main(String[] args) {
        Test a = new Test(true);
        Test b = new Test(false);
        Thread t1 = new Thread(a);
        Thread t2 = new Thread(b);
        t1.start();
        t2.start();
    }

}

// 同步函数使用的锁是this
class Test implements Runnable {
    private boolean flag = true;
    int num = 100;

    Test(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        if (flag) {
            synchronized (MyLock.locka) {
                System.out.println(Thread.currentThread().getName() + "...if...locka....");
                synchronized (MyLock.lockb) {
                    System.out.println(Thread.currentThread().getName() + "...if...lockb....");

                }
            }
        } else {
            synchronized (MyLock.lockb) {
                System.out.println(Thread.currentThread().getName() + "...else...lockb....");
                synchronized (MyLock.locka) {
                    System.out.println(Thread.currentThread().getName() + "...else...locka....");
                }
            }
        }
    }

}

class MyLock {
    public final static Object locka = new Object();
    public final static Object lockb = new Object();
}
