package com.pattern.singleton;

public class Singleton2 {

    public static void main(String[] args) {

    }

    private static Singleton2 singleton2 = null;

    private Singleton2() {

    }

    public Singleton2 getInstan() {
        if (singleton2 == null) {
            singleton2 = new Singleton2();
        }
        return singleton2;
    }
}
