package com.myjava.pattern.strategyPattern;

//strategy Pattern 策略模式
public interface Strategy {

    //每个锦囊妙计都是一个可执行的算法
    public void operate();

    //再写三个实现类，有三个妙计
}
