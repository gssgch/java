package com.myjava.pattern.builderPattern.demo1;

public class BmwModel extends CarModel {

    @Override
    protected void alarm() {
        System.out.println("宝马车的喇叭");
    }

    @Override
    protected void engineBoom() {
        System.out.println("宝马车的引擎");
    }

    @Override
    protected void start() {
        System.out.println("宝马车跑起来是这样的");
    }

    @Override
    protected void stop() {
        System.out.println("宝马车这么停");
    }

}
