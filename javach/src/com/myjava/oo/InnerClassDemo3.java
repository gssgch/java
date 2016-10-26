package com.myjava.oo;

public class InnerClassDemo3 {

    public static void main(String[] args) {
        Outer3 out = new Outer3();
        out.method();
    }

}

/*
 * 内部类可以存放在局部位置上
 *
 * 内部类在局部位置上只能访问局部中被final修饰的局部变量
 */
class Outer3 {

    int num = 1;

    void method() {
        final int x = 9; // 此处的变量必须是final
        class Inner {
            void show() {
                System.out.println("show run..." + x); // 方法里的值
            }
        }
        Inner in = new Inner();
        in.show();
    }
}
