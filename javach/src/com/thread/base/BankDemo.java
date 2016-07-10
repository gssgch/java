package com.thread.base;

/*
 * 需求：储户，，两个，每个都到银行存钱，每次存100 共三次
 */
public class BankDemo {

    public static void main(String[] args) {
        Cus c = new Cus();
        Thread t1 = new Thread(c);
        Thread t2 = new Thread(c);
        t1.start();
        t2.start();
    }
}

class Cus implements Runnable {
    private Bank b = new Bank();

    @Override
    public void run() {
        for (int x = 0; x < 3; x++) {
            b.add(100);
        }
    }

}

class Bank {
    private int sum;

    //    private Object obj = new Object();

    public synchronized void add(int num) { // 同步函数
        // 把同步加到函数上
        //        synchronized (obj) {
        sum = sum + num;
        // 如果不加同步锁，在这里sleep一下，就会报问题
        System.out.println("sum:" + sum);
        //        }
    }
}