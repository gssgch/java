package com.oo;

public class Test {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new Zi3();
    }

}

class Fu3 {
    Fu3() {
        show();
    }

    void show() {
        System.out.println("heheh");
    }
}

class Zi3 extends Fu3 {
    int num = 9;

    Zi3() {
        super();
        // 显示初始化
        System.out.println("zi constructor 。。" + num);
    }

    @Override
    void show() {
        System.out.println("show..." + num);
    }
}