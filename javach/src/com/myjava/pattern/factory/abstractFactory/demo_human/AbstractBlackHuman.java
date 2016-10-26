package com.myjava.pattern.factory.abstractFactory.demo_human;

//抽象产品    使用抽象类是为了防止new一个抽象对象
public abstract class AbstractBlackHuman implements Human {
    @Override
    public void cry() {
        System.out.println("黑人会哭");
    }

    @Override
    public void laugh() {
        System.out.println("黑人会笑");
    }

    @Override
    public void talk() {
        System.out.println("黑人可以说话，一般人听不懂");
    }
}
