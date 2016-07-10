package com.thread.zxx;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *  线程同步工具  Exchanger
 * Date: Aug 16, 2015 2:01:36 PM   Author: ch
 */
public class ExchangerTest {

    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        final Exchanger exchanger = new Exchanger();
        service.execute(new Runnable() {
            @Override
            public void run() {
                try {

                    String data1 = "zxx";
                    System.out.println("线程" + Thread.currentThread().getName() + "正在把数据" + data1 + "换出去");
                    Thread.sleep((long) (Math.random() * 10000));
                    String data2 = (String) exchanger.exchange(data1);
                    System.out.println("线程" + Thread.currentThread().getName() + "换回的数据为" + data2);
                } catch (Exception e) {

                }
            }
        });
        service.execute(new Runnable() {
            @Override
            public void run() {
                try {

                    String data1 = "lhm";
                    System.out.println("线程" + Thread.currentThread().getName() + "正在把数据" + data1 + "换出去");
                    Thread.sleep((long) (Math.random() * 10000));
                    String data2 = (String) exchanger.exchange(data1);
                    System.out.println("线程" + Thread.currentThread().getName() + "换回的数据为" + data2);
                } catch (Exception e) {

                }
            }
        });
    }
}
