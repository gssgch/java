package com.thread.aaa;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//synchronized和java.util.concurrent.locks.Lock的异同
public class ThreadTest {

    private int i;
    private Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        ThreadTest tt = new ThreadTest();
        for (int j = 0; j < 2; j++) {
            new Thread(tt.new Adder()).start();
            new Thread(tt.new Subtractor()).start();
        }
    }

    private class Subtractor implements Runnable {
        @Override
        public void run() {
            while (true) {
                //				synchronized(ThreadTest.this){
                //					System.out.println("i--:"+i--);
                //					//写上这行代码就不执行这个run 方法了
                //				}
                lock.lock();
                try {
                    System.out.println("i--=:" + i--);
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    private class Adder implements Runnable {
        @Override
        public void run() {
            while (true) {
                //				synchronized(ThreadTest.this){
                //					System.out.println("i++:"+i++);
                //					//同步后，这个方法不执行了
                //				}
                lock.lock();
                try {
                    System.out.println("i++:" + i++);
                } finally {
                    lock.unlock();
                }
            }
        }
    }

}
