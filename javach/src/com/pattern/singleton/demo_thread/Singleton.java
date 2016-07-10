package com.pattern.singleton.demo_thread;

/**
 * 多线程下的单例模式 可以给线程加一把锁 synchronized:确保当一个线程位于代码的临界区时，另一个线程不进入临界区，
 * 如果其他线程试图进入锁定的代码，则它将一直等待，直到该对象被释放
 * 
 */
public class Singleton {

    private static Singleton instance;
    private static Object syncRoot = new Object();

    private Singleton() {
    }

    public static Singleton getInstance() {
        synchronized (syncRoot) {
            if (instance == null) {
                instance = new Singleton();
            }
        }
        return instance;
    }
    // 双重锁定
    // if(instance==null){
    // synchronized(syncRoot){
    // if(instance==null){
    // instance=new Singleton();
    // }
    // }
    // }
}
