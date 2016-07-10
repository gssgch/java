package com.baodian._assert;

//assertion:断言，在软件开发中时一种常用的调试方式，
//对boolean表达式进行检查，一个正确程序必须保证这个boolean表达式的值为true，如果该值为false，说明程序已经处于不正确的状态下，
//assert将给出警告或退出
public class AssertTest {

    public static void main(String[] args) {
        int i = 0;
        for (i = 0; i < 5; i++) {
            System.out.println(i);
        }
        //假设程序不小心多了一句 --i;
        --i;
        assert i == 5;
    }
}
