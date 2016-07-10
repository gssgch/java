package com.baodian.overload_override;

public class Test {

    public static void main(String[] args) {
        Dog dog = new Dog("黑色", "小黑");
        Monkey monkey = new Monkey("黄色", "阿黄");
        Master master = new Master();
        master.train(dog);
        master.train(monkey);
    }
}
