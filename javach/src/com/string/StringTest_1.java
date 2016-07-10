package com.string;

/*
 * 给定一个字符串数组，按照字典顺序进行从小到大的排序
 *
 * 思路：
 * 1，对数组排序，可以用选择，冒泡等
 * 2，for嵌套和比较以及换位
 * 3，问题，排整数，用比较运算符。排对象，有方法，compareTo
 */
public class StringTest_1 {

    public static void main(String[] args) {

        String[] arr = { "nba", "ca", "qq", "poi", "klj" };

        System.out.println("比较前：");
        printArray(arr);
        sortString(arr);
        System.out.println();
        System.out.println("比较后：");
        printArray(arr);
        System.out.println();

    }

    public static void sortString(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i].compareTo(arr[j]) > 0) {
                    swap(arr, i, j);
                }
            }
        }
    }

    private static void swap(String[] arr, int i, int j) {

        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }

    public static void printArray(String[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            if (i != (arr.length - 1)) {
                System.out.print(arr[i] + ",");
            } else {
                System.out.print(arr[i] + "]");
            }
        }
    }
}
