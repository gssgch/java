package com.myjava.oo.mianshi;

// 面试题
public class Test2 {

    public static void main(String[] args) {

    }

}

// ---------
class Super {
    int i = 0;

    public Super(String a) {
        System.out.println("A");
    }

    public Super() {
        System.out.println("B");
        i += 2;
    }

}

class Demod extends Super {
    public Demod(String a) {
        System.out.println("C");
        i += 5;
    }

    public static void main(String[] args) {
        int i = 4;
        Super d = new Demod("A");
        System.out.println(d.i);
    }
}

// B C 7
//-----------------

interface Inter2 {
    void show(int a, int b);

    void func();
}

class Demoin {
    public static void main(String[] args) {
        // 补足代码，调用两个函数，要求用匿名内部类。
        Inter2 in = new Inter2() {
            @Override
            public void show(int a, int b) {
            }

            @Override
            public void func() {
            }
        };

        in.show(3, 4);
        in.func();
    }
}

//------------
// 写出程序结果
class TD {
    int y = 6;

    class Inner {
        //                static int y = 3; //非静态内部类里不能定义静态成员

        void show() {
            System.out.println();
        }
    }
}

class TC {
    public static void main(String[] args) {
        TD.Inner ti = new TD().new Inner();
        ti.show();
    }
}

//----------------

class Demos {
    int show(int a, int b) {
        return 0;
    }
}

// 下面哪些函数可以存在于Demos的子类中；

class ZiDemo extends Demos {
    @Override
    public int show(int a, int b) { // 可以，覆盖
        return 0;
    }
    //     //不可以，权限不够
    //    private int show(int a, int b) {
    //        return 0;
    //    }
    //     // 可以，子类特有的方法
    //    private int show(int a, long b) {
    //        return 0;
    //    }
    //      //  不可以，调用的不确定性
    //    public short show(int a, int b) {
    //        return 0;
    //    }
    //      //  静态只能覆盖静态
    //    static int show(int a, int b) {
    //        return 0;
    //    }
}