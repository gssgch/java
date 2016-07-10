package com.pattern.factory.factoryMethod;

//具体工厂，产生对应的具体产品
public class BenzDriver implements Driver {

    @Override
    public Car driveCar() {
        return new Benz();
    }

}
