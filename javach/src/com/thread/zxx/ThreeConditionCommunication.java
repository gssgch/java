package com.thread.zxx;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Date: Aug 8, 2015 12:56:53 PM   Author: ch
 * 使用 Lock 和 Condition实现
 * 主线程循环100次，接着子线程2运行10次，接着子线程3循环20次,接着主线程再循环100次。。。
 * 如此循环50次
 */
public class ThreeConditionCommunication {
    public static void main(String[] args) {

        final Business business = new Business();
        new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 1; i <= 50; i++) {
                    business.sub2(i);
                }

            }
        }).start(); // 线程2
        new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 1; i <= 50; i++) {
                    business.sub3(i);
                }

            }
        }).start(); // 线程3

        for (int i = 1; i <= 50; i++) {
            business.main(i); // 主线程
        }
    }

    static class Business { // 单独弄一个线程同步对象
        private boolean bShouldSub = true; // 判断变量

        Lock lock = new ReentrantLock(); // 创建锁对象
        Condition condition1 = lock.newCondition();
        Condition condition2 = lock.newCondition();
        Condition condition3 = lock.newCondition();

        private int shouldSub = 1;

        public/*synchronized*/void sub2(int i) { // 子线程2
            lock.lock();
            try {
                while (shouldSub != 2) { //
                    try {
                        condition2.await();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                for (int j = 1; j <= 10; j++) {
                    System.out.println("sub2 thread sequence of " + j + ",loop of " + i);
                }
                shouldSub = 3;
                condition3.signal(); // 唤醒3
            } finally {
                lock.unlock();
            }
        }

        public void sub3(int i) { // 子线程3
            lock.lock();
            try {
                while (shouldSub != 3) {
                    try {
                        condition3.await();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                for (int j = 1; j <= 20; j++) {
                    System.out.println("sub3 thread sequence of " + j + ",loop of " + i);
                }
                shouldSub = 1;
                condition1.signal(); // 唤醒1
            } finally {
                lock.unlock();
            }
        }

        public void main(int i) {
            lock.lock();
            try {
                while (shouldSub != 1) {
                    try {
                        condition1.await();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                for (int j = 1; j <= 100; j++) {
                    System.out.println("main thread sequence of " + j + ",loop of " + i);
                }
                shouldSub = 2;
                condition2.signal();
            } finally {
                lock.unlock();
            }
        }
    }
}