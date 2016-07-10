package com.oo;

public class InnerClassDemo2 {

    public static void main(String[] args) {
        Outer2 out = new Outer2();
        out.method();
    }

}

class Outer2 {

    int num = 1;

    class Inner {
        int num = 5;

        void show() {
            int num = 222;
            System.out.println("show run..." + num); // 方法里的值
            System.out.println("show run..." + this.num); // 5  类的成员变量
            System.out.println("show run..." + Outer2.this.num); // 访问Outer的变量
        }

    }

    public void method() {
        Inner in = new Inner();
        in.show();
    }
}
