package com.oo;

/*

 */
public class InnerClassDemo5 {

    class Inner {

    }

    public static void main(String[] args) {
        show(new Inter() {
            @Override
            public void show() {
            };

            @Override
            public void show2() {
            };
        });

        //        new Inner();  // 因为类不是静态的
    }

    public void method() {
        new Inner(); // 这里实际是 this.new Inner();
    }

    public static void show(Inter in) {
        in.show();
        in.show2();

    }

}

interface Inter {
    void show();

    void show2();
}

/*
 * 通常的使用场景之一：
 * 当函数参数是接口类型时，而且接口中的方法不超过三个。
 * 可以使用匿名内部类作为实际参数进行传递。
 */
class Outer5 {

    int num = 1;

    //    class Inner implements Inter {
    //        @Override
    //        public void show() {
    //            System.out.println("show run..." + num);
    //        }
    //
    //        @Override
    //        public void show2() {
    //        }
    //    }

    public void method() {
        //        new Inner().show();
        Inter in = new Inter() {
            @Override
            public void show() {
                System.out.println("show ...." + num);
            }

            @Override
            public void show2() {
                System.out.println("show ...." + num);
            }
        };

        in.show();
        in.show2();
    }
}
