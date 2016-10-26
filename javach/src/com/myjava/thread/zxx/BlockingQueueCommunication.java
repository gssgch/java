package com.myjava.thread.zxx;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Date: Aug 8, 2015 12:56:53 PM   Author: ch
 * 传统线程通信
 * 子线程运行10次，接着主线程循环100次，接着又回到子线程循环10次，接着又回到主线程循环100，
 * 如此循环50次
 */
public class BlockingQueueCommunication {
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

    static class Business { // 单独弄一个线程同步对象
        BlockingQueue<Integer> queue1 = new ArrayBlockingQueue<Integer>(1);
        BlockingQueue<Integer> queue2 = new ArrayBlockingQueue<Integer>(1);

        { // 此处不能加static，因为加static后就在类加载时 执行这里的逻辑，此时对象还未创建呢
          // 这里是匿名构造方法，每次创建对象时，都会执行这里的逻辑
            try {
                queue2.put(1);
            } catch (InterruptedException e) {
            }
        }
        private boolean bShouldSub = true; // 判断变量

        public void sub(int i) { // 子线程
            try {
                queue1.put(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int j = 1; j <= 10; j++) {
                System.out.println("sub thread sequence of " + j + ",loop of " + i);
            }
            try {
                queue2.take();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                //e.printStackTrace();
            }
        }

        public void main(int i) {
            try {
                queue2.put(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int j = 1; j <= 100; j++) {
                System.out.println("main thread sequence of " + j + ",loop of " + i);
            }
            try {
                queue1.take();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                //e.printStackTrace();
            }
        }
    }
}