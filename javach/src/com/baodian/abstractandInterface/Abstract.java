package com.baodian.abstractandInterface;

public abstract class Abstract {

    //抽象类中可以有静态方法
    public static void method1() {

    }

    //可以有非抽象的普通方法
    public void method2() {

    }

    //抽象类中肯定可以有抽象方法,抽象方法的访问类型可以是public protected和默认类型,不能是private,
    //因为abstract的methods就是让子类实现的，同理，abstract method 前不能加final
    public abstract void method3();

    protected abstract void method4();

    //也可以是默认类型(friendly)
    abstract void method5();

    //抽象方法不能用private修饰
    //	private abstract void aaa();

    //抽象类中可以有构造方法
    public Abstract() {

    }

    //可以有静态成员变量，抽象类中静态成员变量的访问类型任意
    public static String grade;

    @SuppressWarnings("unused")
    private static String name;

    static String sex;

    //可以有普通成员变量
    public int age;

}
