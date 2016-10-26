package com.myjava.collection.generic;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

import com.myjava.collection.demo.Person;

public class GenericAdvanceDemo {

    public static void main(String[] args) {
        //        ArrayList<String> ls1 = new ArrayList<String>();
        //        ls1.add("hehhe");
        //        ls1.add("hehhe2");
        //        ls1.add("hehhe3");
        //        printCollection(ls1);
        //        ArrayList<Integer> ls2 = new ArrayList<Integer>();
        //        ls2.add(3);
        //        ls2.add(4);
        //        ls2.add(5);
        //        printCollection(ls1);

        TreeSet<Person> tr = new TreeSet<Person>();
        tr.add(new Person("abc4", 23));
        tr.add(new Person("abc1", 25));
        tr.add(new Person("abc2", 21));

        TreeSet<Person> tr2 = new TreeSet<Person>();
        tr2.add(new Person("abc4", 23));
        tr2.add(new Person("abc1", 25));
        tr2.add(new Person("abc2", 21));

        TreeSet<Person> tr3 = new TreeSet<Person>();
        tr3.add(new Person("abc4", 23));
        tr3.add(new Person("abc1", 25));
        tr3.add(new Person("abc2", 21));

        TreeSet<Person> tr4 = new TreeSet<Person>();
        tr4.add(new Person("abc4", 23));
        tr4.add(new Person("abc1", 25));
        tr4.add(new Person("abc2", 21));

        Iterator<Person> it = tr.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

    }

    /*
     *  迭代并打印集合中的元素    通配符
     *
     *  可以对类型进行限定：
     *  ？  extends E：接受E类型或者E类型的子类型对象。 上限！
     *  ？  super E:接收E类型或者E的父类型。 下限！
     *
     *  一般存储元素的时候都是使用上限，因为这样取出都是按照上限类型来运算的，不会出现类型安全隐患。
     */

    public static void printCollection(Collection<?> ls1) {
        Iterator<?> it = ls1.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    // 这样也可以
    public static <T> void printCollection2(Collection<T> ls1) {
        Iterator<T> it = ls1.iterator();
        while (it.hasNext()) {
            T t = it.next();
            System.out.println(it.next());
        }
    }

    // 泛型限定的上限
    public static void printCollection3(Collection<? extends Person> ls1) {
        Iterator<? extends Person> it = ls1.iterator();
        while (it.hasNext()) {
            Person p = it.next();
            System.out.println(p);
        }
    }

}

// 一般存储元素的时候都是使用上限，因为这样取出都是按照上限类型来运算的，不会出现类型安全隐患。
class MyCollection<E> {
    public void add(E e) {
    }

    public void addAll(MyCollection<? extends E> e) {

    }
}

/*
 * 对集合中的元素进行取出操作时，可以使用下限
 */
class CompByName implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        int temp = o1.getName().compareTo(o2.getName());
        return temp == 0 ? o1.getAge() - o2.getAge() : temp;
    }

}

class CompByStuName implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        int temp = o1.getName().compareTo(o2.getName());
        return temp == 0 ? o1.getAge() - o2.getAge() : temp;
    }

}
