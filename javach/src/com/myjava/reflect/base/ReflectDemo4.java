package com.myjava.reflect.base;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ReflectDemo4 {

    public static void main(String[] args) throws Exception {
        //        getMethodDemo();
        //        getMethodDemo2();
        getMethodDemo3();
    }

    public static void getMethodDemo3() throws Exception {
        Class clazz = Class.forName("com.myjava.reflect.base.Person");
        Method method = clazz.getMethod("get", String.class, int.class); // 获取有参数一般方法
        Object obj = clazz.newInstance();
        method.invoke(obj, "张三", 20);

    }

    // 获取单个方法   无参数
    public static void getMethodDemo2() throws Exception {
        Class clazz = Class.forName("com.myjava.reflect.base.Person");
        Method method = clazz.getMethod("show", null); // 获取空参数一般方法
        Object obj = clazz.newInstance();
        Constructor constructor = clazz.getConstructor(String.class, int.class);
        Object o = constructor.newInstance("zhangsan", 23);
        method.invoke(obj, null);
        method.invoke(o, null);
    }

    /*
     * 获取指定Class中的公共函数
     */
    public static void getMethodDemo() throws Exception {
        Class clazz = Class.forName("com.myjava.reflect.base.Person");
        Method[] methods = clazz.getMethods(); // 获取的都是公有的方法。
        methods = clazz.getDeclaredMethods(); // 只获取本类中所有方法，包含私有。
        for (Method m : methods) {

            System.out.println(m);
        }
    }

}
