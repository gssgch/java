package com.myjava.io.base.objectstream;

import java.io.Serializable;

/*
 * Serializable :用于给被序列化的类加入ID号
 * 用于判断类和对象是否是同一个版本
 */
public class Person implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String name;
    private int age;

    // 瞬时 状态值和静态状态值   都不会被序列化
    //    private transient String name2; // 非静态数据不想被序列化可以使用这个关键字修饰
    //    private static int age2; // 静态值

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

}
