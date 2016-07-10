package com.thread.zxx;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Date: Aug 8, 2015 12:56:53 PM   Author: ch
 * Condition线程通信
 */
public class ConditionCommunication {
    public static void main(String[] args) {

        final Business business = new Business();
        new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 1; i <= 50; i++) {
                    business.sub(i);
                }

            }
        }).start();

        for (int i = 1; i <= 50; i++) {
            business.main(i);
        }
    }

    // ConditionCommunication.Business.class
    // Business.class
    // 因为之前的类里有重名的，所有这个类移动到外部内里面来，并用static来修饰
    static class Business { // 单独弄一个线程同步对象
        private boolean bShouldSub = true; // 判断变量

        Lock lock = new ReentrantLock(); // 创建锁对象
        Condition condition = lock.newCondition();

        public/*synchronized*/void sub(int i) { // 子线程
            lock.lock();
            try {
                while (!bShouldSub) { //
                    try {
                        // this.wait();
                        condition.await(); // 这里要是有await，而不是wait，wait是object的对象
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                for (int j = 1; j <= 10; j++) {
                    System.out.println("sub thread sequence of " + j + ",loop of " + i);
                }
                bShouldSub = false;
                // this.notify();
                condition.signal();
                // notify 和wait必须在synchronized代码块里面写
                // synchronized对象使用哪个对象，那么notify前面使用的就必须是哪个对象
            } finally {
                lock.unlock();
            }
        }

        public void main(int i) {
            lock.lock();
            try {
                while (bShouldSub) {
                    try {
                        // this.wait();
                        condition.await();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                for (int j = 1; j <= 100; j++) {
                    System.out.println("main thread sequence of " + j + ",loop of " + i);
                }
                bShouldSub = true;
                // this.notify();
                condition.signal();
            } finally {
                lock.unlock();
            }
        }
    }
}