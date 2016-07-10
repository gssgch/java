package com.baodian.digui;

//一个整数，大于0，不用循环和本地变量，按照n,2n,4n,8n的顺序递增，当值大于5000时，把值按照指定顺序输出
public class DiGui {

    public static void main(String[] args) {

        doubleNum(1237);
    }

    public static void doubleNum(int n) {
        System.out.println(n);
        if (n <= 5000) {
            doubleNum(n * 2);
            //程序运行到这一步的时候，调用自己的方法doubleNum(int n),然后执行上面的输出，
            //等全部执行完毕,才会执行下面的输出
        }
        System.out.println("1:" + n);
    }

}
