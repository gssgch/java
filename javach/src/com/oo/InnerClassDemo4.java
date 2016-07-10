package com.oo;

/*
 * 匿名内部类，就是内部类的简写格式
 *
 * 必须有前提：
 * 内部类必须继承或者实现一个外部类或接口
 *
 * 匿名内部类：其实就是一个匿名子类对象
 * 格式： new 父类or接口(){子类内容};
 */
public class InnerClassDemo4 {

    public static void main(String[] args) {
        Outer4 out = new Outer4();
        out.method();
    }

}

abstract class Demo {
    abstract void show();
}

class Outer4 {

    int num = 1;

    /* class Inner extends Demo {
         void show() {
             System.out.println("show run..." + num);
         }
     }*/

    public void method() {
        //        new Inner().show();
        new Demo() {
            @Override
            void show() {
                System.out.println("show ...." + num);
            }
        }.show();
    }
}
