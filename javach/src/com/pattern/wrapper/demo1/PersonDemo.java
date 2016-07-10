package com.pattern.wrapper.demo1;

/*
 * 设计模式之装饰模式
 */
public class PersonDemo {

    public static void main(String[] args) {
        Person p = new Person();
        NewPerson p1 = new NewPerson(p);
        p1.eat();
        NewPerson2 p2 = new NewPerson2();
        p2.eat();
    }

}

class Person {
    void eat() {
        System.out.println("吃饭");
    }
}

// 这个类的出现是为了增强person而出现
class NewPerson {
    private Person p;

    NewPerson(Person p) {
        this.p = p;
    }

    public void eat() {
        System.out.println("开胃酒");
        p.eat();
        System.out.println("甜点");
    }
}

// 继续方式
class NewPerson2 extends Person {
    @Override
    public void eat() {
        System.out.println("开胃酒");
        super.eat();
        System.out.println("甜点");
    }
}