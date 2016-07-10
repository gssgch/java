package com.baodian.test;

@SuppressWarnings("unused")
public class Test00 {

    static {
        int x = 10, y, i = 0;
    }

    public static void main(String[] args) {
        int x = 10;
        x--;
        myTest();
        System.out.println(x++);
    }

    public static void myTest() {
        int x = 10, y;
        System.out.println(y = x++ + x--);
    }
}
