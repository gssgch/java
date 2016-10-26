package com.myjava.javacode.test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Test1 {

    static String str = "hellow world";

    public static void f(int s) {
    }

    public static void f(String s) {
    }

    public static void testBigDecimal() {

        BigDecimal b1 = new BigDecimal(2.0);
        BigDecimal b2 = new BigDecimal("2.0");
        System.out.println(b1);
        System.out.println(b2);

    }

    public static void testShadow() {
        String str = "hell";
        System.out.println(str);
    }

    public static void testIntArray() {
        Integer[] b = new Integer[3];
    }

    public static void testRandom() {
        Random random = new Random(10000);
        Math.random();
        for (int i = 1; i < 4; i++) {
            System.out.println("第" + i + "次：" + random.nextInt());
        }
    }

    public static boolean isOdd(int i) {
        return (i % 5) == 1;
    }

    //不要在单个的表达式中对相同的变量赋值 超过一次
    public static void testint() {
        int j = 0;
        for (int i = 0; i < 100; i++) {
            j = j++;
        }
        System.out.println(j);
    }

    //每当要将一个byte序列转换成一个String时，都在使用一个字符集，不管是否显示的指定了它
    public static void testByte() {
        byte[] bytes = new byte[256];
        for (int i = 0; i < 256; i++) {
            bytes[i] = (byte) i;
        }
        String str = new String(bytes);
        for (int j = 0, n = str.length(); j < n; j++) {
            System.out.print((int) str.charAt(j) + "\n");
        }
    }

    //原始类型数组不能作为asList的输入参数，否则会引起程序逻辑混乱。
    public static void testArray() {
        int[] data = { 1, 2, 3, 4, 5 };
        List list = Arrays.asList(data);
        System.out.println("列表中的元素数量是：" + list.size());//结果是1
    }

    public static void testArray2() {
        ArrayList<String> list = new ArrayList<String>();
        list.add("A");
        list.add("B");
        list.add("C");

        List<String> subList = list.subList(0, 2);
        //原字符串增加一个元素
        list.add("D");

        System.out.println("原列表长度：" + list.size());
        System.out.println("子列表长度：" + subList.size());//运行时会报错
    }

    //使用嵌套循环时，将大循环放在内部。
    public static void testForeach() {
        int f = 0;
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 100; j++) {
                for (int k = 0; k < 10; k++) {
                    System.out.print("第" + (f++) + "次：" + i + " " + j + " " + k + ";");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    public static void testForeachyou() {
        int f = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 100; j++) {
                for (int k = 0; k < 1000; k++) {
                    System.out.print("第" + (f++) + "次：" + k + " " + j + " " + i + ";");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    public static void add() {
        double num1 = 152;
        double num2 = 16;
        Double res = num1 / num2;
        //        String a = res.toString();
        //        String c = a.substring(0, a.indexOf(".") + 3);

        System.out.println(res);
    }

    public static void main(String[] args) {

        //        static String System;
        //        testBigDecimal();
        //        testShadow();
        //        testRandom();
        //        System.out.println(isOdd(3));
        //        testint();
        //        testByte();
        //        testArray2();
        //        testForeach();
        //        testForeachyou();
        add();
    }
}
