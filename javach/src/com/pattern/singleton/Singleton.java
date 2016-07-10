package com.pattern.singleton;

import java.util.HashMap;

/*
 * 在GOF中认为最好的一种方式是维护一张存有对象和对应名称的注册表（可使用HashMap）
 * */
public class Singleton {

    // 存放对应关系
    private static HashMap sin = new HashMap();
    static private Singleton s = new Singleton();

    // 受保护的构造函数
    protected Singleton() {

    }

    public static Singleton getInstance(String name) {
        if (name == null) {
            name = "Singleton";
        }
        if (sin.get(name) == null) {
            try {
                sin.put(name, Class.forName(name).newInstance());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return (Singleton) (sin.get(name));
    }

    public void test() {
        System.out.println("getClassSuccess!");
    }

}
