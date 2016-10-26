package com.myjava.pattern.factory.simpleFactory;

/**
 * 
 * 工厂类角色 根据逻辑判断产生不同的产品
 * 
 * @author Administrator
 * 
 */
public class Driver {
    public static Car driverCar(String s) throws Exception {
        if (s.equalsIgnoreCase("Benz")) {
            return new Benz();
        } else if (s.equalsIgnoreCase("Bmw")) {
            return new Bmw();
        } else if (s.equalsIgnoreCase("Audo")) {
            return new Audo();
        } else {
            throw new Exception();
        }
    }
}
