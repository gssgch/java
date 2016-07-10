package com.baodian.meiju;

//用法六：使用接口组织枚举
public interface Demo6 {

    enum Coffee implements Demo6 {
        BLACK_COFFEE, DECAF_COFFEE, LATTE, CAPPUCCINO
    }

    enum Dessert implements Demo6 {
        FRUIT, CAKE, GELATO
    }
}
