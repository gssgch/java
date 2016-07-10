package com.reflect.base;

import java.lang.reflect.Field;

public class ReflectDemo3 {

    public static void main(String[] args) throws Exception {
        //        createNewObject1();
        createNewObject2();
    }

    /*
     * 获取字节码文件中的字段
     */
    public static void createNewObject2() throws Exception {
        String name = "com.reflect.base.Person";
        Class clazz = Class.forName(name);
        Field field = null; // clazz.getField("age"); // 只能获取共有的、
        field = clazz.getDeclaredField("age"); // 只获取本类，但包含私有。
        // 对私有字段的访问取消权限检查。 暴力访问。
        field.setAccessible(true);
        Object obj = clazz.newInstance();
        // 设置值
        field.set(obj, 89);
        Object o = field.get(obj);
        System.out.println(o);
    }

}
