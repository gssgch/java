package com.myjava.collection.generic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.myjava.collection.demo.Person;

public class GenericAdvanceDemo5 {

    public static void main(String[] args) {
        ArrayList<Person> ls1 = new ArrayList<Person>();
        ls1.add(new Person("abc", 23));
        ls1.add(new Person("abc2", 13));

        ArrayList<Person> ls2 = new ArrayList<Person>();
        ls1.add(new Person("abc2222", 25));
        ls1.add(new Person("abc2333", 27));

        ArrayList<String> lss = new ArrayList<String>();
        lss.add("sdfsd");
        lss.add("sde");

    }

    public static void printCollection(Collection<?> ls1) {
        Iterator<?> it = ls1.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}

// 一般存储元素的时候都是使用上限，因为这样取出都是按照上限类型来运算的，不会出现类型安全隐患。
class MyCollection2<E> {
    public boolean containsAll(MyCollection2<?> coll) {
        return false;

    }
}
