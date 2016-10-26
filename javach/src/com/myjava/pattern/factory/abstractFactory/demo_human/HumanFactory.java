package com.myjava.pattern.factory.abstractFactory.demo_human;

//抽象工厂
public interface HumanFactory {
    // 制造黄种人
    public Human createYellowHuman();

    // 制造白种人
    public Human createWhiteHuman();

    // 制造黑种人
    public Human createBlackHuman();
}
