package com.myjava.thread.base;

/*  停止线程：
 *
 * 1，stop方法。已过时
 * 2，run方法结束。
 * 怎么控制线程的任务结束呢？
 * 控制循环通常用定义标记来完成。
 *
 * 可以使用interrupt()方法将线程从冻结状态强制恢复到运行状态中来，
 * 让线程具备cpu的执行资格。
 *
 */
public class StopThreadDemo {

    public static void main(String[] args) {
        StopThread st = new StopThread();
        Thread t1 = new Thread(st);
        Thread t2 = new Thread(st);
        t1.start();
        t2.start();
        int num = 1;
        for (;;) {
            if (++num == 50) {
                // 设置标记暂停线程 ，但有同步和wait后，不起作用
                //                st.setFlag();

                // 状态的临时改变
                t1.interrupt();
                t2.interrupt();
                break;
            }
            System.out.println("...main" + num);
        }
        System.out.println("over");
    }

}

class StopThread implements Runnable {
    private boolean flag = true;

    @Override
    // 使用标记可以改变线程状态
    //    public void run() {
    //        while (flag) {
    //            System.out.println(Thread.currentThread().getName() + "............");
    //        }
    //    }
    public synchronized void run() {
        while (flag) {
            try {
                wait(); // 加同步，加wait后，使用标记（setFlag）也不能暂停这个线程，因为都wait了
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + "..." + e);
                flag = false;
            }
            System.out.println(Thread.currentThread().getName() + "............");
        }
    }

    public void setFlag() {
        flag = false;
    }
}