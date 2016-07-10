package com.pattern.factory.factoryMethod;

//客户端  土豪
public class Manager {
    public static void main(String[] args) {
        try {
            Driver driver = new BenzDriver();
            Car car = driver.driveCar();
            car.dirve();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
