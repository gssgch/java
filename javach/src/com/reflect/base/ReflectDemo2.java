package com.reflect.base;

import java.lang.reflect.Constructor;

public class ReflectDemo2 {

    public static void main(String[] args) throws Exception {
        //        createNewObject1();
        createNewObject2();
    }

    /*
     *  当获取指定名称对象类中的所体现的对象时，而该对象初始化不使用空参数构造该怎么办呢：？
     *  既然是通过指定的构造函数进行对象的初始化，所以应该先获取到该构造函数，通过字节码文件对象即可完成。
     *  该方法是：getConstructor(paramterTypes);
     */
    public static void createNewObject2() throws Exception {
        String name = "com.reflect.base.Person";
        Class clazz = Class.forName(name);
        Constructor constructor = clazz.getConstructor(String.class, int.class);
        Object obj = constructor.newInstance("张三", 32);
        Person p = (Person) obj;
        System.out.println("--name:" + p.getName() + "--age:" + p.getAge());
    }

    public static void createNewObject() throws Exception {

        // 早期：new的时候，先根据被new的类的名称找寻该类的字节码文件，并加载进内存，
        // 并创建该字节码文件对象，并接着创建该字节文件的对应的Person对象。
        com.reflect.base.Person p = new com.reflect.base.Person();

        // 现在
        String name = "com.reflect.base.Person";
        // 找寻该名称类文件，并加载进内存，并产生Class对象。
        Class clazz = Class.forName(name);
        // 如果产生该类的对象
        Object obj = clazz.getInterfaces();

    }

}
