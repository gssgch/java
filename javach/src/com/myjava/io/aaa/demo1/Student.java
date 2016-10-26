package com.myjava.io.aaa.demo1;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Student implements Serializable {

    private String name;
    private int age;
    private Grade grade;

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

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

}
