package com.myjava.collection.news;

/*
 * 函数的可变参数：
 * 其实就是一个数组，但是接收的是数组的元素
 * 自动将这些元素封装成数组，简化了调用者的书写
 *
 * 注意：可变参数类型，必须定义在参数列表的结尾处
 */
public class ParameterDemo {
    public static void main(String[] args) {
        int[] arr = { 1, 3, 5, 6, 9 };
        System.out.println(add(arr));
        int sum = newAdd(1, 3, 5, 6, 9);
        int sum2 = newAdd2(1, 3, 5, 6, 1, 9);
        System.out.println("sum:" + sum);
        System.out.println("sum2:" + sum2);
    }

    public static int newAdd(int... arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    public static int newAdd2(int a, int... arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum + a;
    }

    public static int add(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

}
