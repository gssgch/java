package com.oo;

public class Test2 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new Zi4();
    }

}

class Fu4 {
    Fu4() {
        super();
        //显示初始化
        //构造代码块初始化
        System.out.println("fu constructor 。。"); // 1 fu

        show();
    }

    void show() {
        System.out.println("heheh"); // 被覆盖，运行子类的。
    }
}

class Zi4 extends Fu4 {
    int num = 9;
    {
        System.out.println("constructor code..." + num); // 3
        num = 10;
    }

    Zi4() {
        super();
        // 显示初始化
        //构造代码块初始化
        System.out.println("zi constructor 。。" + num); // 4
        show();
    }

    @Override
    void show() {
        System.out.println("zi show..." + num);// 2  zi show 0  //5 zi show
    }
}