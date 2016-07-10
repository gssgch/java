package com.reflect.aaa;

public class stu {

    private String name = "abc";
    private int age = 18;
    public int grade = 2;

    //无参构造方法
    public stu() {
        System.out.println("这个构造方法没有参数");
    }

    private stu(String name) {
        this.name = name;
    }

    //有参构造方法
    public stu(String name, int age) {

        this.name = name;
        this.age = age;
        System.out.println("这个构造方法有参数");
    }

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

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public void printqy34() {
        System.out.println("执行printqy34()");
    }

    public int oneJiaTwo(int one, int two) {

        return one + two;
    }

}
