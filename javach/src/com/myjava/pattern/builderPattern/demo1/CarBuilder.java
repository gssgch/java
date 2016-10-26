package com.myjava.pattern.builderPattern.demo1;

import java.util.ArrayList;

/*
 * 定义一个模型，需要什么顺序就组装什么顺序
 */
public abstract class CarBuilder {
    // 建造一个模型，需要一个组装顺序
    public abstract void setSequence(ArrayList<String> sequence);

    // 拿车的模型
    public abstract CarModel getCarModel();
}
