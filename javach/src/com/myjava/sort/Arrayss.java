package com.myjava.sort;

import java.util.Arrays;

//使用工具类Arrays进行数组排序   Arrays.sort()默认升序排列
public class Arrayss {

    public static void main(String[] args) {
        //定义一个长度为10 的整形数组并初始化
        int[] intArray = new int[] { 4, 9, 5, 8, 2, 1, 7, 3, 6, 0 };
        //数组排序
        Arrays.sort(intArray);
        //排序后的整形数组输出
        System.out.println("整形数组排序后的结果：");
        for (int n : intArray) {
            System.out.print(n + "\t");
        }
        System.out.println();
        //定义一个长度为5的字符串数组并初始化
        String[] stringArray = new String[] { "Welcome", "Java", "World", "to",
                "!" };
        Arrays.sort(stringArray);
        System.out.println("字符串数组排序后的结果：");
        for (String n : stringArray) {
            System.out.print(n + "\t");
        }
        System.out.println();
    }
}
