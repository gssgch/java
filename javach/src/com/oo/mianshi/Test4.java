package com.oo.mianshi;

// 面试题
public class Test4 {

    public static void main(String[] args) {

    }

}

// --------- 写出程序运行结果
class Super3 {
    int i = 0;

    public Super3(String s) {
        i = 1;
    }

}

/*class Demo4 extends Super3 {
    public Demo4(String s) {
        super(); // 父类中没有空参构造函数，编译失败

        i = 2;
    }

    public static void main(String[] args) {
        Demo4 d = new Demo4("yes");
        System.out.println(d.i);
    }
}*/

// -------------写出运行结果

class Demo5 {
    public static void func() {
        try {
            throw new Exception();
            //            System.out.println("A");// 该语句无法被执行，废话
        } catch (Exception e) {
            System.out.println("B");
        }
    }

    public static void main(String[] args) {
        try {
            func();
        } catch (Exception e) {
            System.out.println("C");
        }
        System.out.println("D");
    }

}

//-------------
class Demo6 {
    public void func() {
        //位置1
        new Inner();
    }

    class Inner {
    }

    public static void main(String[] args) {
        Demo6 d = new Demo6();
        // 位置2
        //        new Inner();
        // 不可以，因为主函数是静态的，只能调用静态成员，所以内部类也必须是static的
    }
}

/*
 * 在位置1 写 new Inner();
 * 在位置2 写 new Inner();
 * 在位置2 写 new d.Inner(); // new new Demo6().Inner(); 格式错误     new Demo6().new Inner();
 * 在位置2 写 new Demo6.Inner(); // 格式是正确的，但是Inner必须是静态的。
 */

// ------------------ 写出运行结果
class Exc0 extends Exception {
}

class Exc1 extends Exc0 {
}

class Demo7 {
    public static void main(String[] args) {
        try {

        } catch (Exception e) { // 多catch时，父类的catch放在最小面
            System.out.println("Exception");
        }
        //        catch (Exc0 e) {
        //            System.out.println("Exc0");
        //
        //        }
    }
}
