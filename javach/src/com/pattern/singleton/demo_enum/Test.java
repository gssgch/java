package com.pattern.singleton.demo_enum;

public class Test {
    public static void main(String[] args) {

        // 单例枚举测试
        Singleton s = Singleton.ONE;
        System.out.println(Singleton.ONE.hashCode());
        Singleton s2 = Singleton.ONE;
        s2.hashCode();
        System.out.println(s2.hashCode());
    }
}
