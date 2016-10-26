package com.myjava.thread.zxx;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Date: Aug 7, 2015 8:19:46 PM   Author: ch
 * 传统定时器
 */
public class TraditionalTimerTest {

    private static int count = 0;

    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        // 过多长时间之后炸
        /*new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("bombing!");
            }
        }, 1000);*/
        // 过多长时间炸，然后每隔多长时间炸
        /*        new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        System.out.println("bombing!");
                    }
                }, 10000, 3000);*/

        // 子母弹
        /*new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("bombing!");
                new Timer().schedule(new TimerTask() {
                                     @Override
                                     public void run() {
                                     System.out.println("bombing!");
                                     }
                                     }this, 3000); // 用this会报错
            }
        }, 3000);*/

        // 升级的子母弹   2' 和 4' 交替
        class MyTimerTask extends TimerTask {
            @Override
            public void run() {
                count = (count + 1) % 2;
                System.out.println("bombing!");
                new Timer().schedule(new MyTimerTask(), 2000 + (2000 * count));
            }
        }
        new Timer().schedule(new MyTimerTask(), 2000);

        while (true) {
            System.out.println(new Date().getSeconds());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                //e.printStackTrace();
            }
        }
    }
}
