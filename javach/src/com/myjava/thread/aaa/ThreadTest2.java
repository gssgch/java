package com.myjava.thread.aaa;

//设计4个线程，其中两个每次对j增加1，另外两个线程对j每次减少1，
//下面的方法用内部类实现线程，对j增减的时候没有考虑顺序问题

public class ThreadTest2 {

    private int j;

    public static void main(String[] args) {
        ThreadTest2 tt2 = new ThreadTest2();
        Inc inc = tt2.new Inc();
        Dec dec = tt2.new Dec();
        for (int i = 0; i < 2; i++) {
            Thread t = new Thread(inc);
            t.start();
            t = new Thread(dec);
            t.start();
        }
    }

    private synchronized void inc() {
        j++;
        System.out.println(Thread.currentThread().getName() + "-inc:" + j);
    }

    private synchronized void dec() {
        j++;
        System.out.println(Thread.currentThread().getName() + "-dec:" + j);
    }

    class Inc implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                inc();
            }
        }
    }

    class Dec implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                dec();
            }
        }
    }

}
