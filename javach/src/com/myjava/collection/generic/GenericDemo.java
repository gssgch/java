package com.myjava.collection.generic;

import java.util.Iterator;
import java.util.TreeSet;

/*
 * 泛型的使用
 */
public class GenericDemo {

    public static void main(String[] args) {

        TreeSet<Person> ts = new TreeSet<Person>();
        ts.add(new Person("zhangsan", 12));
        ts.add(new Person("lisi", 13));
        ts.add(new Person("zhangliu", 15));
        ts.add(new Person("zhangsan", 11));
        Iterator<Person> it = ts.iterator();
        while (it.hasNext()) {
            Person p = it.next();
            System.out.println(p.getName() + "----" + p.getAge());
        }
    }

}

class Person implements Comparable<Person> {
    private String name;
    private int age;

    public Person() {
        super();
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int hashCode() {
        return name.hashCode() + age;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Person)) {
            throw new ClassCastException("类型错误");
        }
        Person p = (Person) obj;
        return this.name.equals(p.name) && (this.age == p.age);
    }

    @Override
    public int compareTo(Person p) {
        int temp = this.age - p.age;
        return temp == 0 ? this.name.compareTo(p.name) : temp;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return this.name + ":" + age;
    }

}
