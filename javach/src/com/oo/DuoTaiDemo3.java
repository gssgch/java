package com.oo;

public class DuoTaiDemo3 {

    public static void main(String[] args) {
        Fu2 f = new Zi2();
        System.out.println(f.num); // 父类中的num
        f.show();
        Fu2.method();
    }

}

class Fu2 {
    int num = 3;

    public void show() {
        System.out.println("fu show");
    }

    static void method() {
        System.out.println("fu method");
    }
}

class Zi2 extends Fu2 {
    int num = 4;

    @Override
    public void show() {
        System.out.println("zi show");
    }

    static void method() {
        System.out.println("zi method");
    }
}
