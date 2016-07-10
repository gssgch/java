package com.array;

import java.util.Arrays;

// 数组排序
public class SortDemo {

    public static void main(String[] args) {

        int[] arr = { 12, 21, 32, 53, 57, 89 };

        int index = halfSearch_2(arr, 45);
        System.out.println("index:" + index);

        int index1 = Arrays.binarySearch(arr, 45);
        // 如果存在，返回具体的角标位置，如果不存在，返回-插入点-1.
        System.out.println("index1:" + index1);
    }

    // 提示排序的性能
    public static void test() {
        int[] arr = { 1, 423, 2345, 24, 2 };
        for (int x = 0; x < (arr.length - 1); x++) {
            int num = arr[x];
            int index = x;
            for (int y = x + 1; y < arr.length; y++) {
                if (num > arr[y]) {
                    num = arr[y];
                    index = y;
                }
            }
            if (index != x) {
                int temp = 0;
                temp = arr[x];
                arr[x] = arr[index];
                arr[index] = temp;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "  ");
        }
    }

    // 二分查找法   返回key值的位置     前提是数组必须是有序的
    public static int halfSearch(int[] arr, int key) {

        int max, min, mid;
        min = 0;
        max = arr.length - 1;
        mid = (min + max) / 2;
        while (arr[mid] != key) {
            if (key > arr[mid]) {
                min = mid + 1;
            } else if (key < arr[mid]) {
                max = mid - 1;
            }
            if (max < min) {
                return -1;
            }
            mid = (max + min) / 2;
        }
        return mid;
    }

    public static int halfSearch_2(int[] arr, int key) {

        int max, min, mid;
        min = 0;
        max = arr.length - 1;
        mid = (min + max) / 2;
        while (min <= max) {
            mid = (max + min) >> 1; // 右移一位，相当于除以2
            if (key > arr[mid]) {
                min = mid + 1;
            } else if (key < arr[mid]) {
                max = mid - 1;
            } else {
                return mid;
            }
        }
        //        return -1;
        return mid; // 如果是找要插入元素的位置，就返回mid
    }

}
