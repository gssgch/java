package com.pattern.factory.simpleFactory;

//具体产品
public class Benz implements Car {

    @Override
    public void dirve() {
        System.out.println("Driving Benz");
    }

}
