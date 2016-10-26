package com.myjava.oo;

public class InnerClassDemo {

    public static void main(String[] args) {
        Outer out = new Outer();
        out.method();
        //        直接访问外部类中的内部类的成员。
        //        Outer.Inner in = new Outer().new Inner();

        //        如果内部类是静态的，相当于一个外部类。
        //        Outer.Inner in2 = new Outer.Inner();

        //        如果内部类是静态的，成员是静态的。
        Outer.Inner.function();
    }

}

class Outer {

    private static int num = 31;

    static class Inner { // 内部类
        void show() {
            System.out.println("show run..." + num);
        }

        static void function() { // 如果内部类中定义了静态成员，那么该内部类也必须是静态的
            System.out.println("static function");
        }
    }

    public void method() {
        Inner in = new Inner();
        in.show();
    }
}
