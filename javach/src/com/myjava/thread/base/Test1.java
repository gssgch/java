package com.myjava.thread.base;

// 初识多线程
public class Test1 {

    public static void main(String[] args) {
        Demo d1 = new Demo("王城");
        Demo d2 = new Demo("李四");
        d1.start();
        d2.start();
        for (int i = 0; i < 20; i++) {
            System.out.println(i + "---" + Thread.currentThread().getName());
        }
    }
}

class Demo extends Thread {
    @SuppressWarnings("unused")
    private String name;

    Demo(String name) {
        super(name);
        //        this.name = name;
    }

    @Override
    public void run() {
        show();
    }

    public static void show() {
        for (int i = 0; i < 10; i++) {
            System.out.println("...." + i + "--name" + Thread.currentThread().getName());
        }

    }
}
