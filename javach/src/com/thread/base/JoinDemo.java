package com.thread.base;

/* join方法
 *
 *
 *  线程优先级：0-10   默认为5
 */
public class JoinDemo {

    public static void main(String[] args) throws Exception {
        Demo2 d = new Demo2();
        Thread t1 = new Thread(d);
        Thread t2 = new Thread(d);
        t1.start();
        t2.start();
        t2.setPriority(Thread.MAX_PRIORITY); // 设置线程优先级为最高
        //        t1.join(); // t1线程要申请加入进来，运行   先运行完了该线程，再运行其他的线程
        for (int x = 0; x < 50; x++) {
            System.out.println(Thread.currentThread() + "---" + x);
        }
    }

}

class Demo2 implements Runnable {
    @Override
    public void run() {
        for (int x = 0; x < 50; x++) {
            System.out.println(Thread.currentThread() + "--rrr---" + x);
        }
    }
}