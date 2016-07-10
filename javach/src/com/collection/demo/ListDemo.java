package com.collection.demo;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Vector;

public class ListDemo {

    public static void main(String[] args) {

    }

    // 迭代过程中，不能使用集合同时操作，容易出现异常
    // 可以使用Iterator的子接口ListIterator
    public static void demo_list() {
        List list = new ArrayList();
        list.add("sa1");
        list.add("sa2");
        list.add("sa3");

        System.out.println("list:" + list);

        /*
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Object obj = it.next();
            if (obj.equals("sa2")) {
                list.add("sa5");    //java.util.ConcurrentModificationException
            }
        }*/

        //使用子类 ListIterator  可以实现对元素的增删改查   只有List 集合有
        ListIterator its = list.listIterator();
        while (its.hasNext()) {
            Object obj = its.next();
            if (obj.equals("sa2")) {
                //its.set("sa5"); //替换
                its.add("sss"); // 增加
            }
        }
        System.out.println("its.hasNext():" + its.hasNext()); //是否有下一个
        System.out.println("its.hasPrevious():" + its.hasPrevious()); //是否有前一个
        System.out.println("list:" + list);
    }

    // Enumeration 与Iterator 的功能一样，被Iterator替换
    public static void demo_Vector() {
        Vector v = new Vector();
        v.add("vet1");
        v.add("vet2");
        v.add("vet3");
        v.add("vet4");

        Enumeration en = v.elements();
        while (en.hasMoreElements()) {
            System.out.println("nextElement:" + en.nextElement());
        }

        Iterator it = v.iterator();
        while (it.hasNext()) {
            System.out.println("next:" + it.next());
        }
    }

    public static void demo_link() {
        LinkedList link = new LinkedList();
        link.addFirst("link1");
        link.addFirst("link2");
        link.addFirst("link3");
        link.addFirst("link4");

        System.out.println(link);

        //        System.out.println(link.getFirst()); //获取第一个但不删除
        //        System.out.println(link.getFirst());

        //        System.out.println(link.removeFirst()); //删除第一个
        //        System.out.println(link.removeFirst());
        while (!link.isEmpty()) {
            System.out.println(link.removeFirst());
            //            System.out.println(link.removeLast());
        }
    }

}
