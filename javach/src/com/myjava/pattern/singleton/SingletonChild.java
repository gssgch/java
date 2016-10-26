package com.myjava.pattern.singleton;

public class SingletonChild extends Singleton {
    public SingletonChild() {

    }

    static public SingletonChild getInstance() {
        return (SingletonChild) Singleton.getInstance("SingletonChild");
    }

    @Override
    public void test() {
        System.out.println("getClassOK");
    }
}