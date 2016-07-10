package com.baodian.test;

//代码输出的结果
public class Test05 {

    public static void main(String[] args) {

        Test05 t = new Test05();
        //        System.out.println(t.get());
        System.out.println(t.test());

    }

    @SuppressWarnings("finally")
    public int get() {
        try {
            return 1;
        } finally {
            return 2;
        }
    }

    @SuppressWarnings("finally")
    int test() {
        try {
            return fun1();
        } finally {
            return fun2();
        }
    }

    int fun1() {
        System.out.println("fun1");
        return 1;
    }

    int fun2() {
        System.out.println("fun2");
        return 2;
    }

}
