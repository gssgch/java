package com.baodian.abstractandInterface;

public class Test3 {

    public static void main(String[] args) {
        new C();
        C.main(args);
        new Ball(null).play();
    }
}

interface A {
    int x = 0;
}

class B {
    int x = 1;
}

class C extends B implements A {
    public static void main(String[] args) {
        new C().PX();
    }

    public void PX() {
        //		System.out.println(x);//此处的x指向不明确,接口和父类中都有x
        System.out.println("B:" + super.x);//父类的x
        System.out.println("A:" + A.x);//接口的x
    }

}

//接口找错误
interface Playable {
    void play();
}

interface Bounable {
    void play();
}

interface Rollable extends Playable, Bounable {

    Ball ball = new Ball("PingPang");
    //这里报错的原因：任何在interface里声明的interface variable (接口变量)，默认为public static final
    //即 public static final Ball ball=Ball("PingPang");
}

class Ball implements Rollable {
    private String name;

    public Ball(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void play() {
        //		ball = new Ball("adf");
        //因为接口里面的ball是final的，所以不能改变的
        System.out.println(ball.getName());
    }
}
