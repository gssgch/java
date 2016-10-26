package com.myjava.pattern.factory.simpleFactory;

//客户端
public class Manager {
    public static void main(String[] args) {
        try {
            Car car = Driver.driverCar("bmw");
            car.dirve();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
