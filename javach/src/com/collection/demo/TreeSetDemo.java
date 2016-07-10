package com.collection.demo;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/*TreeSet:可以对Set集合中的元素进行排序。是不同步的。
 * 方法1：根据对象自身的排序
 *
 * 方法2：让集合自身具备比较功能
 *
 */
public class TreeSetDemo {

    public static void main(String[] args) {
        //        treeDemo2(); // 自定义对象自身排序
        //        treeDemo3(); // 自定义了比较器
        treeDemo4();// 字符串长度
    }

    /*
     * 对字符串的长度进行比较
     */
    public static void treeDemo4() {
        TreeSet ts = new TreeSet(new ComparatorByLen()); // 使用比较器
        ts.add("zs");
        ts.add("lisi");
        ts.add("abc");
        ts.add("cba");
        ts.add("fbIa");

        Iterator it = ts.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    @SuppressWarnings("unused")
    private static void treeDemo3() { // 使用自定义比较器
        TreeSet ts = new TreeSet(new ComparatorByName()); // 使用比较器
        ts.add(new Person("zhangsan", 23));
        ts.add(new Person("lisi", 29));
        ts.add(new Person("wangwu", 24));
        ts.add(new Person("zhouqi", 21));
        ts.add(new Person("zhangsan2", 23));

        Iterator it = ts.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    public static void treeDemo2() {
        TreeSet ts = new TreeSet();
        ts.add(new Person("zhangsan", 23));
        ts.add(new Person("lisi", 29));
        ts.add(new Person("wangwu", 24));
        ts.add(new Person("zhouqi", 21));
        ts.add(new Person("zhangsan2", 23));

        Iterator it = ts.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

    }

    public static void treeDemo() {
        TreeSet ts = new TreeSet();

        ts.add("adv");
        ts.add("ab");
        ts.add("ac");
        ts.add("ad");

        Iterator it = ts.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

}

// 根据字符串长度进行比较的比较器
class ComparatorByLen implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        String len1 = (String) o1;
        String len2 = (String) o2;
        int temp = len1.length() - len2.length();
        return temp == 0 ? len1.compareTo(len2) : temp;
    }

}

/*
 * 创建一个根据person类的名称进行比较的比较器
 */
class ComparatorByName implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        Person p1 = (Person) o1;
        Person p2 = (Person) o2;
        int temp = p1.getName().compareTo(p2.getName());
        return temp == 0 ? p1.getAge() - p2.getAge() : temp;
    }

}

//class Persion extends Object {
//    private String name;
//    private int age;
//
//    public Persion() {
//        super();
//    }
//
//    public Persion(String name, int age) {
//        this.name = name;
//        this.age = age;
//    }
//
//    /**
//     * @return the name
//     */
//    public String getName() {
//        return name;
//    }
//
//    /**
//     * @param name the name to set
//     */
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    /**
//     * @return the age
//     */
//    public int getAge() {
//        return age;
//    }
//
//    /**
//     * @param age the age to set
//     */
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    @Override
//    public String toString() {
//        return this.name + ":" + age;
//    }
//
//    @Override
//    public int hashCode() {
//        //        System.out.println(this + ".....hashCode"); // 先判断哈希值，如果不等就不判断equals方法
//        return name.hashCode() + age;
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        if (obj == null) {
//            return false;
//        }
//        if (!(obj instanceof Persion)) {
//            throw new ClassCastException("类型错误");
//        }
//        //        System.out.println(this + "...equals..." + obj);
//        Persion p = (Persion) obj;
//        return this.name.equals(p.name) && (this.age == p.age);
//    }
//    // 使用 shift+alt +s 生成的hashCode和equals方法
//
//    /*    @Override
//        public int hashCode() {
//            final int prime = 31;
//            int result = 1;
//            result = prime * result + age;
//            result = prime * result + ((name == null) ? 0 : name.hashCode());
//            return result;
//        }
//
//        @Override
//        public boolean equals(Object obj) {
//            if (this == obj)
//                return true;
//            if (obj == null)
//                return false;
//            if (getClass() != obj.getClass())
//                return false;
//            Persion other = (Persion) obj;
//            if (age != other.age)
//                return false;
//            if (name == null) {
//                if (other.name != null)
//                    return false;
//            } else if (!name.equals(other.name))
//                return false;
//            return true;
//        }*/
//
//}
