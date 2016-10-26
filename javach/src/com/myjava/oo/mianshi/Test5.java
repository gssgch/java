package com.myjava.oo.mianshi;

//面试题
public class Test5 {
    public static String output = "";

    public static void foo(int i) {
        try {
            if (i == 1) {
                throw new Exception();
            }
            output += "1";
        } catch (Exception e) {
            output += "2";
            return;
        } finally {
            output += "3";
        }
        output += "4";
    }

    public static void main(String[] args) {
        foo(0);
        System.out.println(output); // 134
        foo(1);
        System.out.println(output); // 13423
    }

}

//-------------------------
interface Test {
    void func();
}

class Demo {
    public static void main(String[] args) {
        // 补足代码：匿名内部类，调用show方法
        new Demo().show(new Test() {
            @Override
            public void func() {
                System.out.println(1234);
            };
        });

    }

    void show(Test t) {
        t.func();
    }
}

//--------------------

interface Areable {
    public double getArea();
}

class NoValueException extends RuntimeException {
    NoValueException() {
        super();
    }

    NoValueException(String message) {
        super(message);
    }
}

class Rec implements Areable { // 长方形
    private int length;
    private int width;

    Rec(int length, int width) {
        if ((length <= 0) || (width <= 0)) {
            throw new NoValueException("数值非法");
        }
        this.length = length;
        this.width = width;
    }

    @Override
    public double getArea() {
        return length * width;
    }
}

class Circle implements Areable {
    private static final double PI = 3.14;
    private int radius;

    Circle(int radius) {
        if (radius <= 0) {
            throw new NoValueException("半径值非法");
        }
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return radius * radius * PI;
    }
}

class TestArea {
    public static void main(String[] args) {
        Rec r = new Rec(-3, 5);
        double a = r.getArea();
        System.out.println("area:" + a);
    }
}

// -----------------

class Demo2 {
    private static int j = 0;

    private static boolean methodB(int k) {
        j += k;
        return true;
    }

    public static void methodA(int i) {
        boolean b;
        b = (i < 10) | methodB(4);
        b = (i < 10) || methodB(8);
    }

    public static void main(String[] arg) {
        methodA(0);
        System.out.println(j); // 4
    }
}