package com.javacode.test;

public class test6 {
    static {
        System.out.println("test6");
    }

    public test6() {
        System.out.println("test6s");
    }

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        test6 test = new Test5();
        System.out.println("---------------------");
        test = new Test5();
    }
}

class Test5 extends test6 {
    static {
        System.out.println("test5");
    }

    public Test5() {
        System.out.println("test51");
    }
}
