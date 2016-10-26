package com.myjava.thread.base;

/* 卖票
 *
 * 线程安全问题产生的原因：
1，多个线程在操作共享的数据。
2，操作共享数据的线程代码有多条。

解决思路：
将多条操作共享数据的线程代码封装起来，当有线程在执行这些代码的时候，其他线程不可以参与运算。
必须等当前线程把这些代码都执行完毕之后，其他线程才可以参与运算。

在java中 ，使用同步代码块可以解决问题
 同步代码块格式：
 synchronized(){
 }
 */
public class TicketDemo {

    public static void main(String[] args) {
        /*
         * 继承Thread类时：
         *   Ticket t1 = new Ticket();
          Ticket t2 = new Ticket();
          Ticket t3 = new Ticket();
          Ticket t4 = new Ticket();
          t1.start();
          t2.start();
          t3.start();
          t4.start();*/

        Ticket t = new Ticket(); // 创建一个线程任务对象
        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);
        Thread t3 = new Thread(t);
        Thread t4 = new Thread(t);
        t1.start();
        t2.start();
        t3.start();
        t4.start();

    }

}

//class Ticket extends Thread {
class Ticket implements Runnable { // 使用实现接口
    private int num = 100;

    Object obj = new Object();

    @Override
    public void run() {
        while (true) {
            //            Object obj = new Object(); // 如果在这里创建对象，每个线程都有自己的锁，还是会出问题
            synchronized (obj) {

                if (num > 0) {
                    try {
                        Thread.sleep(10); // 能看出线程不同步导致的问题
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "...sale..." + num--);
                }
            }
        }
    }
}
