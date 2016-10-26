package com.myjava.oo.api;

import java.util.Properties;
import java.util.Set;

public class SystemDemo {
    private static final String LINE_SEPARATOR = System.getProperty("line.separator");

    // System:类中的方法和属性都是静态的
    public static void main(String[] args) {
        System.out.println("hello" + LINE_SEPARATOR + " world");
        demo_1();
    }

    /*
     *  获取系统的属性信息，并存储到了properties集合中。
     *  properties集合中存储的都是String类型的键和值。
     *  最好使用它自己的存储和取出的方法来完成元素的操作
     *
     */
    public static void demo_1() {
        Properties prop = System.getProperties();
        Set<String> nameSet = prop.stringPropertyNames();
        for (String name : nameSet) {
            String value = prop.getProperty(name);
            System.out.println(name + "::" + value);
        }
    }

}
