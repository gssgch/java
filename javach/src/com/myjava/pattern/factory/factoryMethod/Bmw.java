package com.myjava.pattern.factory.factoryMethod;

//具体产品
public class Bmw implements Car {
    @Override
    public void dirve() {
        System.out.println("Driving Bmw");
    }
}
