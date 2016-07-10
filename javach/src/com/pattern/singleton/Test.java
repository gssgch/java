package com.pattern.singleton;

//这个单例模式有点问题
public class Test {

    public static void main(String[] args) {
        // SingletonChild s = new SingletonChild();
        // s.getInstance();
        Singleton s = new Singleton();
        Singleton.getInstance("Singleton");
    }
}
