package com.myjava.thread.zxx;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Date: Aug 14, 2015 10:24:45 PM   Author: ch
 */
public class CacheDemo {
    private Map<String, Object> cache = new HashMap<String, Object>();

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    private ReadWriteLock rwl = new ReentrantReadWriteLock();

    /*
     *  读写之间互斥，写写之间互斥，读读之间不互斥，
     *  第一次执行时，上写锁，然后检查缓存中是否有数据，如果没有数据，就去查（写）数据，否则就直接返回数据
     *  读锁   填充数据时，上写锁，
     */
    public synchronized Object getData(String key) {
        rwl.readLock().lock();
        Object value = null;
        try {
            value = cache.get(key);
            if (value == null) {
                rwl.readLock().unlock(); // 读锁释放
                rwl.writeLock().lock(); // 写锁 上锁
                try {
                    /*
                     * 这里加一个if判断的原因是：
                     * 当有多个线程 上写锁时，如果第一个线程抢到执行权（则其他线程等待），然后执行赋值语句，
                     * 然后释放读锁，上写锁。
                     * 当等待的线程上写锁之后，如果不加判空，会发生重复执行语句
                     */
                    if (value == null) {
                        value = "aaa"; // 实际是去查db
                    }
                } finally {
                    rwl.writeLock().unlock();
                }
                rwl.readLock().lock();
            }
        } finally {
            rwl.readLock().unlock();
        }
        return value;
    }

}
