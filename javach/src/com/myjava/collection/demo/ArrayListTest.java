package com.myjava.collection.demo;

import java.util.ArrayList;
import java.util.Iterator;

/*
 * 去除ArrayList中的重复对象
 */
public class ArrayListTest {

    public static void main(String[] args) {
        //        removeDemo1();
        removeDemo2();
    }

    public static void removeDemo2() { // 去除自定义对象的重复元素   需要重写equals方法才能去除重复
        ArrayList array = new ArrayList();
        array.add(new Person("lis", 24));
        array.add(new Person("lis2", 25));
        array.add(new Person("lis2", 25));
        array.add(new Person("lis3", 26));
        array.add(new Person("lis3", 26));
        array.add(new Person("lis", 24));
        System.out.println(array);

        array = getSingeElement(array);
        System.out.println(array);
    }

    public static void removeDemo1() {
        ArrayList array = new ArrayList();
        array.add("zhangs");
        array.add("lis");
        array.add("lis");
        array.add("wangwu");
        array.add("wangwu");
        System.out.println(array);

        array = getSingeElement(array);
        System.out.println(array);
    }

    private static ArrayList getSingeElement(ArrayList array) {
        ArrayList temp = new ArrayList();
        Iterator it = array.iterator();
        while (it.hasNext()) {
            Object obj = it.next();
            if (!temp.contains(obj)) { // contains判断的依据是equals方法
                temp.add(obj);
            }
        }
        return temp;
    }

}
