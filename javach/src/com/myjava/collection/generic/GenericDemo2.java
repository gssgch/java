package com.myjava.collection.generic;

public class GenericDemo2 {

    public static void main(String[] args) {
        testDemo2();
        testDemo3();
    }

    public static void testDemo3() { //静态方法上的泛型
        Tool.method("ss");
        Tool.method(new Integer(3));

    }

    public static void testDemo2() { // 泛型定义在方法上
        Tool<Person> ts = new Tool<Person>();
        Person str = new Person("zhangsan", 13);
        ts.show(str);
        ts.show(45);
        ts.show("adfds");
        ts.show(new Integer(3));
    }

    public static void testDemo1() { // 使用泛型
        Tool<Person> ts = new Tool<Person>();
        Person p = new Person("zhangsan", 13);
        ts.setQ(p);
    }

}
