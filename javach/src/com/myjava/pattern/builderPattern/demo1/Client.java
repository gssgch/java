package com.myjava.pattern.builderPattern.demo1;

import java.util.ArrayList;

public class Client {
    public static void main(String[] args) {
        ArrayList<String> sequence = new ArrayList<String>();
        sequence.add("engineBoon");// 先发动引擎
        sequence.add("start");// 启动
        sequence.add("stop");// 停

        // 要一个奔驰车
        BenzBuilder benzBuilder = new BenzBuilder();
        benzBuilder.setSequence(sequence);
        BenzModel benz = (BenzModel) benzBuilder.getCarModel();
        benz.run();

        // 要一个宝马车
        BmwBuilder bmwBuilder = new BmwBuilder();
        bmwBuilder.setSequence(sequence);
        BmwModel bmw = (BmwModel) bmwBuilder.getCarModel();
        bmw.run();

        Director director = new Director();
        // 1万辆A类型的奔驰车
        for (int i = 0; i < 10000; i++) {
            director.getABenzModel().run();
        }
        // 100万辆B类型的奔驰车
        for (int i = 0; i < 1000000; i++) {
            director.getBBenzModel().run();
        }
    }
}
