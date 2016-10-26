package com.myjava.oo;

public class ExtendsDemo {

    public static void main(String[] args) {

        Zi z = new Zi();
        z.show();
    }

}

class Fu {

    Fu() {
        super();
        show();
        return;
    }

    public void show() {
        System.out.println("Fu -----show");
    }
}

class Zi extends Fu {

    int num = 9;

    Zi() {
        super();
        //通过super初始化父类内容时，子类的成员变量并未显示初始化，
        //等super()父类初始化完成后，才进行子类的成员变量显示初始化。
        System.out.println("yes or no:" + num);
        return;
    }

    @Override
    public void show() {
        System.out.println("Zi ----show ：" + num);
    }
}