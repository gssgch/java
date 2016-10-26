package com.myjava.pattern.builderPattern.demo1;

public class BenzModel extends CarModel {

    @Override
    protected void alarm() {
        System.out.println("奔驰车的喇叭");
    }

    @Override
    protected void engineBoom() {
        System.out.println("奔驰车的引擎");
    }

    @Override
    protected void start() {
        System.out.println("奔驰车跑起来是这样的");
    }

    @Override
    protected void stop() {
        System.out.println("奔驰车这么停");
    }

}
