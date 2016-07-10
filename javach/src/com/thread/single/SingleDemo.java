package com.thread.single;

public class SingleDemo {
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}

// 饿汉式
class SingleA {
    private static final SingleA s = new SingleA();

    private SingleA() {
    }

    public static SingleA getInstance() {
        return s;
    }

}

//懒汉式
class SingleB {
    private static SingleB s = null;

    private SingleB() {
    }

    public static SingleB getInstance() {
        if (s == null) { // 提升效率
            synchronized (SingleB.class) { // 解决同步
                if (s == null) {
                    s = new SingleB();
                }
            }
        }
        return s;
    }
}