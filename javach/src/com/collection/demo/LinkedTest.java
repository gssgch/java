package com.collection.demo;

/*
 * 使 用LinkedList 来模拟堆栈或者队列数据结构
 *
 *堆栈：先进后出  First In Last Out
 *
 *队列：先进先出  First In First Out
 *
 *应该描述这样一个容器，给使用者提供一个容器对象完成这两种结构中的一种
 *
 */

//  喝酒，白酒，可乐，啤酒     吐：相当于堆栈    wc:相当于队列

public class LinkedTest {

    public static void main(String[] args) {
        DuiLie d = new DuiLie();
        d.myAdd("link12");
        d.myAdd("link13");
        d.myAdd("link14");
        d.myAdd("link15");

        while (!d.isNull()) {
            System.out.println(d.myGet());
        }
    }
}
