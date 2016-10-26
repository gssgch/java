package com.myjava.pattern.factory.abstractFactory.demo_human;

public enum HumanEnum {

    // 把所有人的类型都定义出来
    YellowMaleHuman("com.factory.abstractFactory.demo_human.YellowMaleHuman"), YellowFemaleHuman("com.factory.abstractFactory.demo_human.YellowFemaleHuman"), WhiteMaleHuman("com.factory.abstractFactory.demo_human.WhiteMaleHuman"), WhiteFemaleHuman("com.factory.abstractFactory.demo_human.WhiteFemaleHuman"), BlackMaleHuman("com.factory.abstractFactory.demo_human.BlackMaleHuman"), BlackFemaleHuman("com.factory.abstractFactory.demo_human.BlackFemaleHuman");
    private String value = "";

    // 定义构造函数，目的是Data(value)类型的相匹配
    private HumanEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
