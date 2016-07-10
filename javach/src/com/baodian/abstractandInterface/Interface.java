package com.baodian.abstractandInterface;

public interface Interface {

    //接口中没有普通成员变量，只有静态成员变量，类型默认为且只能是public static final
    public static String name = "";

    //接口中所有的方法必须都是抽象的，不能有非抽象的普通方法，抽象方法只能是public类型的，
    //默认的就是public abstract类型
    public void method1();

    void method2();

    //接口中有静态成员变量，但是没有静态方法

    //接口中没有构造方法
}
