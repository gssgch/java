package com.myjava.pattern.builderPattern.demo1;

import java.util.ArrayList;

/*
 * 定义一个车辆模型的抽象类，所有车辆模型都继承这个类
 */
public abstract class CarModel {

    // 这个参数是各个基本方法的顺序
    private ArrayList<String> sequence = new ArrayList<String>();

    // 启动开始跑
    protected abstract void start();

    protected abstract void stop();

    // 按喇叭
    protected abstract void alarm();

    // 引擎
    protected abstract void engineBoom();

    final public void run() {
        for (int i = 0; i < this.sequence.size(); i++) {
            String actionName = this.sequence.get(i);
            if (actionName.equalsIgnoreCase("start")) {
                this.start();
            } else if (actionName.equalsIgnoreCase("stop")) {
                this.stop();
            } else if (actionName.equalsIgnoreCase("alarm")) {
                this.alarm();
            } else if (actionName.equalsIgnoreCase("engineBoom")) {
                this.engineBoom();
            }
        }
    }

    // 把传递过来的值传递到类里
    final public void setSequence(ArrayList<String> sequence) {
        this.sequence = sequence;
    }
}
