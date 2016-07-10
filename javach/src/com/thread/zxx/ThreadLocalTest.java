package com.thread.zxx;

import java.util.Random;

/**
 * Date: Aug 8, 2015 1:27:12 PM   Author: ch
 * 使用ThreadLocal实现线程范围内共享变量
 * 相当于一个自定义的map
 */
public class ThreadLocalTest {

    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();
    private static ThreadLocal<MyThreadScopeData> myThreadScopeData = new ThreadLocal<MyThreadScopeData>();

    public static void main(String[] args) {

        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int data = new Random().nextInt();
                    System.out.println(Thread.currentThread().getName() + " has put data :" + data);
                    threadLocal.set(data);
                    MyThreadScopeData.getThreadInstance().setName("name" + data);
                    MyThreadScopeData.getThreadInstance().setAge(data);

                    new A().get();
                    new B().get();
                }
            }).start();
        }
    }

    static class A {
        private void get() {
            int data = threadLocal.get();
            System.out.println("A-" + Thread.currentThread().getName() + " get data :" + data);
            MyThreadScopeData myData = MyThreadScopeData.getThreadInstance();
            System.out.println("A-" + Thread.currentThread().getName() + " getMydata :" + myData.getName() + "," + myData.getAge());

        }
    }

    static class B {
        private void get() {
            int data = threadLocal.get();
            System.out.println("B-" + Thread.currentThread().getName() + " get data :" + data);
            MyThreadScopeData myData = MyThreadScopeData.getThreadInstance();
            System.out.println("B-" + Thread.currentThread().getName() + " getMydata :" + myData.getName() + "," + myData.getAge());

        }
    }
}

class MyThreadScopeData {
    private MyThreadScopeData() {
    }

    public static/*synchronized*/MyThreadScopeData getThreadInstance() {
        MyThreadScopeData instance = map.get();
        if (instance == null) {
            instance = new MyThreadScopeData();
            map.set(instance);
        }
        return instance;
    }

    private static ThreadLocal<MyThreadScopeData> map = new ThreadLocal<MyThreadScopeData>();

    private String name;
    private int age;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

}
