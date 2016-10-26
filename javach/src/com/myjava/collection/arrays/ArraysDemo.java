package com.myjava.collection.arrays;

import java.util.Arrays;
import java.util.List;

/*
 *
 * Arrays：集合框架的工具类，里面的方法都是静态的。
 */
public class ArraysDemo {

    public static void main(String[] args) {

        //        testAsList();
        demo2();
        //                int[] array = { 1, 2, 13, 4, 25 };
        //                System.out.println(Arrays.toString(array));
    }

    /*
     * 如果数组中的元素是对象，那么转成集合时，直接将数组中的元素作为集合中的元素进行集合存储。
     * 如果数组中的元素是基本类型数值，那么会将该数组作为集合中的元素进行存储。
     */
    public static void demo2() {
        int[] arr = { 21, 34, 41, 1 };
        Integer[] arr2 = { 21, 34, 41, 1 };
        List list2 = Arrays.asList(arr2);
        List<int[]> list = Arrays.asList(arr);
        System.out.println(list);
        System.out.println(list2);
    }

    /*
     * List asList(数组) 将数组转成集合
     * 好处：可以使用集合中的方法操作数组中的元素
     * 注意：数组的长度是固定的，所以对于集合的增删改查方法是不可以使用到的
     * 否则会发生UnsupportedOperationException
     */
    public static void testAsList() {
        String[] arr = { "heh", "zhangsan", "touch" };
        List<String> list = Arrays.asList(arr);
        boolean b = list.contains("heh");
        System.out.println(b);
    }

    // toString 的经典实现。
    public static String myToString(int[] a) {
        if (a == null) {
            return "null";
        }
        int iMax = a.length - 1;
        if (iMax == -1) {
            return "[]";
        }

        StringBuilder b = new StringBuilder();
        b.append('[');
        for (int i = 0;; i++) { // 中间省略了条件判断，提高了效率
            b.append(a[i]);
            if (i == iMax) {
                return b.append(']').toString();
            }
            b.append(", ");
        }
    }
}
