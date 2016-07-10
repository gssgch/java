package com.javacode.test;

public class Test {

    public static void main(String[] arg) {

        PinyinConv p = new PinyinConv();
        String aString = "张三王五";
        System.out.println(PinyinConv.cn2py(aString.substring(0, 1)).toUpperCase());

        //        test();
        //        testDate();
        //        testDate2();
        //        getMonthEndDay();
        //        testDate3(4);
        //        testDate4();
        //        test5();
        test6();
    }

    //变量互换
    public static void test5() {
        int a = 10;
        int b = 20;
        //法一：
        //        a=b-a;
        //        b=b-a;
        //        a=a+b;
        //法二：
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println(a + "///" + b);
    }

    //把数字字符分割取出
    public static void test6() {
        String str = "123456";
        System.out.println("原字符串长度：" + str.length());
        String[] st = new String[str.length()];
        for (int i = 0; i < str.length(); i++) {
            st[i] = str.substring(i, i + 1);
            System.out.print(st[i] + ",");
        }
    }

}
