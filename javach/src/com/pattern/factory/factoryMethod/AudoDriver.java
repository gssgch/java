package com.pattern.factory.factoryMethod;

//具体工厂，实现抽象工厂，并且生产对应的具体产品
public class AudoDriver implements Driver {
    @Override
    public Car driveCar() {
        return new Audo();
    }

}
