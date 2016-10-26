package com.myjava.reflect.aaa;

public class qy34 {

    private String name;
    private stu stus;

    //无参构造方法
    public qy34() {

    }

    public qy34(String name) {

        this.name = name;
    }

    public qy34(String name, stu stus) {

        this.name = name;
        this.stus = stus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public stu getStus() {
        return stus;
    }

    public void setStus(stu stus) {
        this.stus = stus;
    }

}
