package com.myjava.oo;

/*

 */
public class InnerClassDemo6 {

    public static void main(String[] args) {
        Outer6 out = new Outer6();
        out.method();
    }
}

/*
 */
class Outer6 {

    int num = 1;

    void method() {
        //        new Object() {
        //            public void show() {
        //                System.out.println("show run");
        //            }
        //        }.show();

        Object obj = new Object() {
            public void show() {
                System.out.println("show run");
            }
        };
        //obj.show();
        /*
         * 因为匿名内部类这个子类对象被向上转型为了object类型，
         * 这样就不能再使用子类特有的方法了。
         */
    }
}
