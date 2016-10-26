package com.myjava.thread.base;

/* 生产者，消费者
 *
 * 多生产者 多消费者的问题
 * if判断标记，只有一次，会导致不该运行的线程运行了，出现了数据错误的情况
 * while 判断标记，解决了线程获取执行权后，是否要运行。
 *
 * notify 只能唤醒一个线程， 如果本方唤醒了本方，没有意义。
 * 而且while判断标记+notify会导致死锁。
 * notifyAll解决了本方线程一定会唤醒对方线程的问题。
 *
 * JDK1.5以后，将同步和锁封装成了对象，
 * 并将操作锁的隐式方法定义到了该对象中，将隐式动作变成了显示动作。
 *
 */
public class ProducerConsumerDemo {

    public static void main(String[] args) {
        Resource5 r = new Resource5();
        Producer pro = new Producer(r);
        Consumer con = new Consumer(r);
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

class Resource5 {
    private String name;
    private int count = 1;
    private boolean flag = false;

    public synchronized void set(String name) {
        while (flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.name = name + count;
        count++;
        System.out.println(Thread.currentThread().getName() + "...生产者。。。" + this.name);
        flag = true;
        notifyAll();
    }

    public synchronized void out() {
        while (!flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + "...消费者。。。。。。" + this.name);
        flag = false;
        notifyAll();
    }
}

class Producer implements Runnable {
    private Resource5 r;

    Producer(Resource5 r) {
        this.r = r;
    }

    @Override
    public void run() {
        while (true) {
            r.set("烤鸭");
        }
    }
}

class Consumer implements Runnable {
    private Resource5 r;

    Consumer(Resource5 r) {
        this.r = r;
    }

    @Override
    public void run() {
        while (true) {
            r.out();
        }

    }
}
