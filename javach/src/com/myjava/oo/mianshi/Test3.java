package com.myjava.oo.mianshi;

// 面试题
public class Test3 {

    public static void main(String[] args) {

    }

}

// ---------
class FFu {
    int num = 4;

    void show() {
        System.out.println("show fu");
    }

}

class Zi extends FFu {
    int num = 5;

    @Override
    void show() {

    }
}

class T {
    public static void main(String[] args) {
        FFu f = new Zi();
        Zi z = new Zi();
        System.out.println(f.num);
        System.out.println(z.num);
        f.show();
        z.show();
    }
}

// 4   5   show zi    show zi
//-----------------

interface AC {
    void show();
}

interface AD {
    void add(int a, int b);
}

class CC implements AC, AD {
    // 程序代码
    private int x, y;
    private int sum;

    @Override
    public void add(int a, int b) {
        //        this.x = x;
        //        this.y = y;
        sum = x + y;
    }

    @Override
    public void show() {
        //        System.out.println(x + y);
        System.out.println(sum);
    }
}

class DD {
    public static void main(String[] args) {
        CC c = new CC();
        c.add(4, 1);
        c.show(); // 通过该函数打印以上两个数的和

    }
}

//------------
// 写出程序结果
class Demo3 {
    public static void main(String[] args) {
        try {
            showExce();
            System.out.println("A");
        } catch (Exception e) {
            System.out.println("B");

        } finally {
            System.out.println("C");

        }
    }

    public static void showExce() throws Exception {
        throw new Exception();
    }
}

//  B  C
//----------------
