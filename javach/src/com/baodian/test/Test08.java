package com.baodian.test;

//
public class Test08 {

    public static void main(String[] args) {
        //		byteTest();
        //		intTest();
        //		shortTest();
        //		doubleTest();
        println(12);
        //		stringTest();
    }

    public static void println(int a) {
        System.out.println(a);
    }

    public static void byteTest() {

        byte b = 12;

        System.out.println(b);

        byte b1 = 3;
        byte b2 = 4;
        //		b1=127;//如果b1的值为127，再加上b2的值，就不能赋给b了，超过范围了，即精度的损失
        //	    b=b1+b2;

        //此处的问题， b1和b2是变量，值不能确定， 不能检查，就会报错
        //b的取值范围是-128~127  
    }

    public static void intTest() {
        int a = Integer.MAX_VALUE;
        int b = Integer.MIN_VALUE;
        int a1 = a;
        int aa = a + a1;//int不会编译错误，查过范围就从最小位开始
        System.out.println(aa);
        System.out.println("a:" + a + "\n" + "b:" + b + "\n" + "a+b:" + (a + b));
    }

    public static void test() {
        int a = 3;
        int b = a++;
        //在内存中的做法是 先建一个临时内存区存放a的值，然后a执行自增，然后a在内存中的值更新，
        //最后,再把临时内存中的a值赋给b
    }

    public static void shortTest() {
        short s = 4;
        s += 4;//编译成功     一次运算   在底层做自动转换，不需要强制转换
        //		s=s+4;//编译失败    两次运算，右边是变量值，如果不强转，就报错，精度丢失    不做自动转换
        short sa = Short.MAX_VALUE;
        System.out.println(sa);

    }

    public static void doubleTest() {
        double a = 20;
        double b = 21;
        double c = 15;
        a = b + c;
        a += 4;
        System.out.println(Double.MAX_VALUE);
        System.out.println(Double.MAX_VALUE + 10.02);

    }

    //运算优先级
    public static void stringTest() {
        System.out.println("3+\"2\"=" + (3 + "2"));//32
        System.out.println("3+'2'=" + (3 + '2'));//53
        System.out.println("3+'2'=" + 3 + '2');//32
        //因为有字符串“”,所以先进行的是把3提升为String类型，然后再加上和char类型的相加
        System.out.println(3 + '2');//53
        System.out.println(+5 + 5);//10
        System.out.println("5+5:" + 5 + 5);//55
        System.out.println("5+5=" + 5 + 5);//55
        System.out.println("5+5:" + (5 + 5));//10  加上括号后提升了运算的优先级，先进行括号内的加法运算
    }
}
