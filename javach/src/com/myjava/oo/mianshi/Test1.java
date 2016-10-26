package com.myjava.oo.mianshi;

// 部分面试题
public class Test1 {

    public static void main(String[] args) {
        A a = new B();
        //        System.out.println(a.method()); // 编译失败，因为AA中未定义

    }

}

//----------
// 写出程序结果
interface A {
}

class B implements A {
    public String method() {
        return "method";
    }
}

class Demo1 {
    public static void main(String[] args) {
        A a = new B();
        //        a.method();  // 编译失败，非静态方法，编译看左边，A中没有method 方法
        //        System.out.println(a.method()); // 编译失败
    }
}

//--------

class Fu {
    boolean show(char a) {
        System.out.println(a);
        return true;
    }
}

class Demoo extends Fu {
    public static void main(String[] args) {
        int i = 0;
        Fu f = new Demoo();
        Demoo d = new Demoo();
        for (f.show('A'); f.show('B') && (i < 2); f.show('C')) {
            i++;
            d.show('D');
        }
    }

    @Override
    boolean show(char a) {
        System.out.println(a);
        return false;
    }

}

// 结果为 A B
//-----------
// 写出程序结果
interface AA {
}

class BB implements AA {
    public String test() {
        return "yes";
    }
}

class DemoB {
    static AA get() {
        return new BB();
    }

    public static void main(String[] args) {
        AA a = get(); // 想当于 AA a=new BB();
        //        System.out.println(a.test());
        // 编译失败，AA接口中没有定义test方法
    }
}
