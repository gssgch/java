package com.myjava.pattern.factory.factoryMethod;

//具体产品
public class Benz implements Car {

    @Override
    public void dirve() {
        System.out.println("Driving Benz");
    }

}
