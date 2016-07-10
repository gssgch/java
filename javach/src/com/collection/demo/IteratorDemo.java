package com.collection.demo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/*
 *iterator 的两种循环方式
 */
public class IteratorDemo {

    public static void main(String[] args) {
        Collection coll = new ArrayList();
        coll.add("aa1");
        coll.add("aa2");

        //        Iterator it = coll.iterator();
        //        while (it.hasNext()) {
        //            System.out.println(it.next());
        //        }

        // 开发中使用的方法
        for (Iterator its = coll.iterator(); its.hasNext();) {
            System.out.println(its.next());
        }
    }

}
