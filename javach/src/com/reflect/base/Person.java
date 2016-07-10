package com.reflect.base;

public class Person {
    private String name;
    private int age;

    public Person() {
        super();
        System.out.println("person run");
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return this.name + ":" + age;
    }

    public void show() {
        System.out.println(name + "--show method--" + age);
    }

    public void get(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("name:" + name + "---age:" + age);
    }

    public static void staticMethod() {
        System.out.println("static method run");
    }
}
