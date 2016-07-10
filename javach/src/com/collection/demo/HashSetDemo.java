package com.collection.demo;

import java.util.HashSet;
import java.util.Iterator;

/*
 * HashSet集合数据结构式哈希表，所以存储元素的时候，
 * 使用元素的hashCode方法来确定位置，如果位置相同，再通过元素的equals来确定是否相同
 */
public class HashSetDemo {

    public static void main(String[] args) {

        HashSet hs = new HashSet();

        hs.add(new Person("lis", 24));
        hs.add(new Person("lis2", 25));
        hs.add(new Person("lis3", 26));
        hs.add(new Person("lis", 24));

        Iterator it = hs.iterator();
        while (it.hasNext()) {
            Person p = (Person) it.next();
            System.out.println(p.getName() + "--" + p.getAge());
        }
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
