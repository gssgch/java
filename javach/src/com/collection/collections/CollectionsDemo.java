package com.collection.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class CollectionsDemo {

    public static void main(String[] args) {
        //        demo_1(); // 排序
        //        demo_2(); // 位置
        demo_3(); // 最大值
        demo_4();
    }

    public static void demo_5() { // 倒序
        List<String> list = new ArrayList<String>();
        list.add("abcde");
        list.add("abc");
        list.add("cde");
        list.add("sdfade");
        list.add("zz");
        System.out.println(list);
        Collections.replaceAll(list, "abc", "cba"); // 替换
        Collections.shuffle(list); // 随机排序
        Collections.fill(list, "ccc"); // 替换所有
        System.out.println(list);
    }

    public static void demo_4() { // 倒序
        TreeSet<String> ts = new TreeSet<String>(Collections.reverseOrder());
        // 已有比较器
        //        TreeSet<String> ts = new TreeSet<String>(Collections.reverseOrder(new ComparatorByLength()));
        ts.add("abcde");
        ts.add("abc");
        ts.add("cde");
        ts.add("sdfade");
        ts.add("zz");
        System.out.println(ts);
    }

    public static void demo_3() { // 最大值
        List<String> list = new ArrayList<String>();
        list.add("abcde");
        list.add("abc");
        list.add("cde");
        list.add("sdfade");
        list.add("zz");
        System.out.println(list);

        // 最大值
        String max = Collections.max(list);
        System.out.println("max:" + max);

        // 最长的值
        String maxLen = Collections.max(list, new ComparatorByLength());
        System.out.println("maxLen:" + maxLen);
    }

    public static void demo_2() { // 找位置
        List<String> list = new ArrayList<String>();
        list.add("abcde");
        list.add("abc");
        list.add("cde");
        list.add("sdfade");
        list.add("zz");
        Collections.sort(list);
        System.out.println(list);

        int index = Collections.binarySearch(list, "ddd");
        System.out.println("index:" + index); // 集合中不存在的元素的插入点位置再减1
        int index2 = Collections.binarySearch(list, "zz");
        System.out.println("index2:" + index2); // 插入点
    }

    @SuppressWarnings("unused")
    private static void demo_1() {

        List<String> list = new ArrayList<String>();
        list.add("abcde");
        list.add("abc");
        list.add("cde");
        list.add("sdfade");
        list.add("zz");
        System.out.println(list);

        // 对list集合进行指定顺序的排序
        //        Collections.sort(list);

        mySort(list);
        System.out.println(list);
    }

    public static <T> void mySort(List<T> list, Comparator<? super T> comp) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (comp.compare(list.get(i), list.get(j)) > 0) {

                    Collections.swap(list, i, j);
                }

            }
        }
    }

    public static <T extends Comparable<? super T>> void mySort(List<T> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).compareTo(list.get(j)) > 0) {
                    //                    T temp = list.get(i);
                    //                    list.set(i, list.get(j));
                    //                    list.set(j, temp);

                    Collections.swap(list, i, j);
                }

            }
        }
    }

}
