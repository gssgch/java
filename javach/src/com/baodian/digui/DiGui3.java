package com.baodian.digui;

//斐波那契数列
public class DiGui3 {

    public static void main(String[] args) {

        //		test(10);
        num2(10);
    }

    //递归算法
    public static int num(int n) {
        if ((n == 1) | (n == 0)) {
            return 1; //
        } else if (n > 1) {
            return num(n - 1) + num(n - 2);
        } else {
            return 0;
        }
    }

    public static void test(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(num(i) + "  ");
        }

    }

    //非递归算法
    public static void num2(int n) {
        int sum = 0, sum1 = 0, sum2 = 0;
        for (int i = 0; i < n; i++) {
            if ((i == 0) | (i == 1)) {
                sum = 1;
                System.out.print(sum + "  ");
                sum1 = sum;
                sum2 = sum;
            } else {
                sum = sum1 + sum2;
                System.out.print(sum + "  ");
                sum1 = sum2;
                sum2 = sum;
            }
        }
    }

    public static void test2(int n) {
        int sum = 0, sum1 = 0, sum2 = 0;
        for (int i = 0; i < n; i++) {
            if ((i == 0) | (i == 1)) {
                sum = 1;
                System.out.print(sum + " ");
            } else {
                sum = sum1 + sum2;
                System.out.print(sum + "  ");
                sum1 = sum2;
                sum2 = sum;
            }
        }

    }

}
