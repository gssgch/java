package com.baodian.digui;

//第一个人的编号10，第二个人的编号比第一个人的编码大2，依次类推，用递归的方法计算出第8个人的编号
public class DiGui2 {

    public static void main(String[] args) {

        num(8);
        System.out.println("结果：" + num(8));
    }

    public static int num(int n) {
        System.out.println(n);
        if (n == 1) {
            return 10; //
        }
        System.out.println("--" + (num(n - 1) + 2));
        return num(n - 1) + 2;//如果不是第一个人，编号是前一个的编号加上2
    }

    public static void toBinary(int n, StringBuffer result) {
        if ((n / 2) != 0) {
            toBinary(n / 2, result);
        }
        result.append(n % 2);
    }

}
