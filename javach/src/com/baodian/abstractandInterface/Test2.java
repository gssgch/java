package com.baodian.abstractandInterface;

//java代码找错
public class Test2 {

    public static void main(String[] args) {
        new Prt1().doPrt1();//输出结果为0，是其默认值
        new Prt2().doPrt2();
        new Prt3();
        Prt3.main(args);//直接调用内部类的main方法
    }
}

class Prt1 {
    int i;

    public void doPrt1() {
        System.out.println("i1:" + i);
    }
}

class Prt2 {
    //	final int i;
    final int i = 1;//final修饰的变量必须显示的初始化

    public void doPrt2() {
        System.out.println("i2:" + i);
    }
}

class Prt3 {
    public static void main(String[] args) {
        Prt3 p = new Prt3();
        //		System.out.println("s.doPrt3() returns:"+doPrt3());
        //如果直接写方法，就需要把该方法改为静态方法，(静态方法不能直接访问非静态的方法)
        System.out.println("s.doPrt3() returns:" + p.doPrt3());
        //错误解析：需要new对象调用方法
    }

    public String doPrt3() {
        return "Do prt3......";
    }
}
