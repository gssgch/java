package com.thread.base;

/*
 * 静态同步函数
 * 使用的锁是：该函数所属字节码文件对象，可以用getClass方法获取，
 * 也可以用当前类名.class 来表示。
 */
public class StaticSynFunctionLockDemo {

    public static void main(String[] args) {
        Ticketss t = new Ticketss(); // 创建一个线程任务对象

        /* 获取对象的两种方式
         Class clazz=t.getClass();
         Class clazz=Ticket.class;
         */

        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);
        t1.start(); // 走代码块
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.flag = false;
        t2.start(); // 走同步函数
    }
}

// 同步函数使用的锁是this
class Ticketss implements Runnable { // 使用实现接口
    private static int num = 100;
    boolean flag = true;
    Object obj = new Object();

    @Override
    public void run() {
        if (flag) {
            while (true) {
                synchronized (this.getClass()) { // 获取字节码中的对象
                    if (num > 0) {
                        try {
                            Thread.sleep(10); // 能看出线程不同步导致的问题
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName() + "...obj..." + num--);
                    }
                }
            }
        } else {
            while (true) {
                Ticketss.show();
            }
        }
    }

    public static synchronized void show() {
        if (num > 0) {
            try {
                Thread.sleep(10); // 能看出线程不同步导致的问题
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "...function..." + num--);
        }
    }
}
