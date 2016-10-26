package com.myjava.thread.base;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*  使用lock替换synchronized
 *
 * 多生产者 多消费者的问题

 * JDK1.5以后，将同步和锁封装成了对象，
 * 并将操作锁的隐式方法定义到了该对象中，将隐式动作变成了显示动作。
 *
 *Lock接口：
 *出现替代了同步代码块或者同步函数，将同步的隐式锁操作变成显示锁操作
 *同时更为灵活，可以一个锁上加上多组监视器。
 *lock():获取锁
 *unlock():释放锁，通常需要定义finally代码块中
 *
 * 一个锁挂多个监视器对象
 *
 *Condition接口：
 *出现替代了Object中的wait notify notifyAll 方法。
 *将这些监视器方法单独进行了封装，变成Condition监视器对象。
 *可以任意锁进行组合。
 *
 *await()
 *signal()
 *signalAll()
 *
 */
public class LockDemo {

    public static void main(String[] args) {
        Resource6 r = new Resource6();
        Producer2 pro = new Producer2(r);
        Consumer2 con = new Consumer2(r);
        Thread t0 = new Thread(pro);
        Thread t1 = new Thread(pro);
        Thread t2 = new Thread(con);
        Thread t3 = new Thread(con);
        t0.start();
        t1.start();
        t2.start();
        t3.start();
    }

}

class Resource6 {
    private String name;
    private int count = 1;
    private boolean flag = false;
    // 创建一个锁对象
    Lock lock = new ReentrantLock();
    // 通过已有的锁，获取该锁上的监视器对象
    //    Condition con = lock.newCondition();

    // 通过已有的锁获取两组监视器，一组监视生产者，一组监视消费者
    Condition producer_con = lock.newCondition();
    Condition consumer_con = lock.newCondition();

    public void set(String name) {
        lock.lock(); // 加锁
        try {
            while (flag) {
                try {
                    producer_con.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.name = name + count;
            count++;
            System.out.println(Thread.currentThread().getName() + "...生产者。。。" + this.name);
            flag = true;
            //            notifyAll();
            //            con.signalAll();
            consumer_con.signal();
            ;
        } finally {
            lock.unlock(); // 释放锁
        }
    }

    public void out() {
        lock.lock();
        try {
            while (!flag) {
                try {
                    //                    this.wait();
                    consumer_con.wait(); // 消费者等待
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + "...消费者。。。。。。" + this.name);
            flag = false;
            //            notifyAll();
            //            con.signalAll();
            producer_con.signal(); // 唤醒生产者
        } finally {
            lock.unlock();
        }
    }
}

class Producer2 implements Runnable {
    private Resource6 r;

    Producer2(Resource6 r) {
        this.r = r;
    }

    @Override
    public void run() {
        while (true) {
            r.set("烤鸭");
        }
    }
}

class Consumer2 implements Runnable {
    private Resource6 r;

    Consumer2(Resource6 r) {
        this.r = r;
    }

    @Override
    public void run() {
        while (true) {
            r.out();
        }

    }
}
