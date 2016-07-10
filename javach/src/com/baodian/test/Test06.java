package com.baodian.test;

import java.util.HashSet;
import java.util.Vector;

//去掉一个vector集合中重复的元素
public class Test06 {

    public static void main(String[] args) {

    }

    //方法一
    @SuppressWarnings("null")
    public static void method1() {
        Vector vc = null;
        Vector newvc = new Vector();
        for (int i = 0; i < vc.size(); i++) {
            Object obj = vc.get(i);
            if (!newvc.contains(obj)) {
                newvc.add(obj);
            }
        }
    }

    //方法二
    @SuppressWarnings("unused")
    public static void method2() {
        Vector vc = null;
        HashSet set = new HashSet(vc);
    }

}
