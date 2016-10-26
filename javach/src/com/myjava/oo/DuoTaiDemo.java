package com.myjava.oo;

public class DuoTaiDemo {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Cat c = new Cat();
        method(c);

        Dog d = new Dog();
        method(d);

        Animal a = new Cat();// 自动类型提升，猫对象提升为动物类型，但是特有功能无法访问。
        // 作用就是限制对特有功能的访问。
        // 专业讲：向上转型。

        /*
         * 如果还想用具体动物猫的特有功能。
         * 可以将该的对象进行向下转型
         *
         */
        Cat cc = (Cat) a;// 向下转型的目的是为了使用子类中的特有方法

        //注意：对于转型，自始至终都是子类对象在做着类型的变化
        Animal a1 = new Dog();
        //        Cat C1=(Cat)a1; // ClassCastException
    }

    public static void method(Animal c) {
        c.eat();
    }

}

abstract class Animal {
    abstract void eat();
}

class Dog extends Animal {
    @Override
    void eat() {
        System.out.println("啃骨头");
    }

    void lookHome() {
        System.out.println("看家");
    }
}

class Cat extends Animal {

    @Override
    void eat() {
        // TODO Auto-generated method stub
        System.out.println("吃鱼");
    }

    void catchMouse() {
        System.out.println("抓老鼠");
    }
}