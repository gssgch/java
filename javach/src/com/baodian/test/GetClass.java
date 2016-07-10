package com.baodian.test;

import java.util.Date;

//super.getClass()方法的调用
@SuppressWarnings("serial")
public class GetClass extends Date {

    public static void main(String[] args) {
        new GetClass().test();
        new GetClass().test2();

    }

    //由于getClass()在object类中定义成了final,子类不能覆盖该方法，
    //所以调用getClass().getName()方法，其实就是调用从父类继承的getClass()方法
    public void test() {
        System.out.println(super.getClass().getName());
    }

    //如果想得到父类的名称，用下面的代码
    public void test2() {
        System.out.println(super.getClass().getSuperclass().getName());
    }
}
