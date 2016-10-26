package com.myjava.oo;

public class InterfaceDemo {

    public static void main(String[] args) {
    }

}

interface A {
    public void show();
}

interface B {
    public void method();

}

interface QQ extends A, B { // 接口可以多继承。
    void function();
}

class WW implements QQ {

    @Override
    public void show() {
        // TODO Auto-generated method stub

    }

    @Override
    public void method() {
        // TODO Auto-generated method stub

    }

    @Override
    public void function() {
        // TODO Auto-generated method stub

    }

}
