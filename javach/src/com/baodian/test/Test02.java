package com.baodian.test;

import java.util.StringTokenizer;

//如何把一段逗号分割的字符串转换成一个数组
public class Test02 {

    public static void main(String[] args) {
        test1();
        test2();
    }

    //方法1：用正则表达式，实例如下
    public static void test1() {
        String test = "abc,abcd,abcde,aaa";
        String[] result = test.split(",");
        System.out.println(result[0]);
    }

    //方法二：用StringTokenizer
    @SuppressWarnings("unused")
    public static void test2() {
        String test = "abc,abcd,abcde,aaa";
        StringTokenizer tokener = new StringTokenizer(test, ",");
        String[] result = new String[tokener.countTokens()];
        int i = 0;
        while (tokener.hasMoreElements()) {
            //			result[i++]=tokener.nextToken();
            //注意：此处的nextToken()不能出现两次，不然就会出现值丢失
            System.out.println(tokener.nextToken());
        }

    }

}
