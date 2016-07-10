package com.thread.zxx;

/**
 * Date: Aug 8, 2015 12:56:53 PM   Author: ch
 * 传统线程通信
 * 子线程运行10次，接着主线程循环100次，接着又回到子线程循环10次，接着又回到主线程循环100，
 * 如此循环50次
 */
public class TraditionalThreadCommunication {
    public static void main(String[] args) {

        final Business business = new Business();
        new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 1; i <= 50; i++) {
                    business.sub(i);
                }

            }
        }).start();

        for (int i = 1; i <= 50; i++) {
            business.main(i);
        }
    }
}

class Business { // 单独弄一个线程同步对象
    private boolean bShouldSub = true; // 判断变量

    public synchronized void sub(int i) { // 子线程
        while (!bShouldSub) { //
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int j = 1; j <= 10; j++) {
            System.out.println("sub thread sequence of " + j + ",loop of " + i);
        }
        bShouldSub = false;
        this.notify();
    }

    public synchronized void main(int i) {
        while (bShouldSub) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int j = 1; j <= 100; j++) {
            System.out.println("main thread sequence of " + j + ",loop of " + i);
        }
        bShouldSub = true;
        this.notify();
    }
}
