package com.myjava.thread.zxx;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Date: Aug 7, 2015 8:59:36 PM   Author: ch
 */

// Lock锁
public class LockTest {

    public static void main(String[] args) {
        new LockTest().init();
    }

    private void init() {
        // 在静态方法中，不能new 内部类的对象   所以需要用外部类的对象来调用
        final Outputer outputer = new Outputer();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //                    outputer.output("zhangsan");
                    outputer.output2("zhangsan");
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //                    outputer.output2("lisi");
                    Outputer.output3("lisi");
                }
            }
        }).start();
    }

    static class Outputer {

        Lock lock = new ReentrantLock();

        private void output(String name) {
            int len = name.length();
            lock.lock();
            try {
                // 所以这里需要在类的字节码对象上加锁才能和第三个达成一致
                for (int i = 0; i < len; i++) {
                    System.out.print(name.charAt(i));
                }
                System.out.println();
            } catch (Exception e) {
            } finally {
                lock.unlock();
            }
        }

        public synchronized void output2(String name) {
            int len = name.length();
            for (int i = 0; i < len; i++) {
                System.out.print(name.charAt(i));
            }
            System.out.println();
        }

        // 这个同步方法的锁是这个Outputer的类对象
        public static synchronized void output3(String name) {
            int len = name.length();
            for (int i = 0; i < len; i++) {
                System.out.print(name.charAt(i));
            }
            System.out.println();
        }
    }
}
