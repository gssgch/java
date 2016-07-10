package com.baodian.test;

public class Test {

    public static void main(String[] args) {
        test_byte_int3();
        test();
    }

    @SuppressWarnings("unused")
    public static void test_byte_int1() {
        int x = 3;
        byte b = 5;
        x = x + b;

        byte c = 3;
        c = (byte) (b + 200); //强制类型转换

        System.out.println((char) ('a' + 1));
        System.out.println('你' + 0); // unicode国际标准码表

    }

    @SuppressWarnings("unused")
    public static void test_byte_int2() {
        byte b = 4;
        b = 3 + 7; // 输出正常
        byte b1 = 3;
        byte b2 = 7;
        //        b = b1 + b2;  // 不确定的变量是不能计算的，有精度损失
        int x = b1 + b2; // int范围更大，完全装得下

    }

    public static void test_byte_int3() {
        int x, xx;
        int x1 = 10;
        int x3 = Integer.MAX_VALUE;
        int x2 = 5;
        x = x1 + x2; // 默认类型，底层有强制转换
        System.out.println(x);
        xx = x1 + x3;
        System.out.println(xx);
    }

    // 赋值运算符
    public static void test() {
        int a = 3;
        a++; // a=a+1;
        System.out.println(a); // 4

        int a1 = 3, b;
        b = a1++;
        // 可以简单理解为： 先进行赋值运算，再 进行自加1
        // 先整个临时变量，存储a1的值，再对a1进行自增1，内存中a1值为 4，再把临时变量中a的值3，赋给b
        System.out.println("a1:" + a1 + ",b:" + b);
        int a2 = 3, c;
        c = ++a2;
        System.out.println("a2:" + a2 + ",c:" + c);
        int i = 3;
        i = i++;
        // i=i++; temp=i; i=i+1; i=temp;
        //         3       4        3
        // 临时变量temp存储i的值3，i自增后内存中i=4，再把临时变量中i的值3赋给i
        System.out.println("i:" + i);
    }

    @SuppressWarnings("unused")
    public static void test2() {
        // +=  -= *=  /= : 左右两边的和（差，积，商）赋给左边
        short s = 3;
        s += 4; // 一次运算   底层有自动强制转换功能     赋值后做检查，会自动转换
        //        s=s+4; // 编译报错  两次运算   需要强转

    }
}
