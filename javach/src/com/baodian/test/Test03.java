package com.baodian.test;

//用最有效的方法算出2乘以8等于几
public class Test03 {
    //将一个数左移n位，就相当于乘以了2的n次方，一个数乘以8只要将其左移3位即可
    public static void main(String[] args) {

        System.out.println();
        System.out.println("2<<3:" + (2 << 3));//2乘以2的3次方
        System.out.println("1<<1:" + (1 << 2));//1乘以2的2次方

        System.out.println("5<<3:" + (5 << 3));//5乘以2的3次方

    }
}
