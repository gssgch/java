package com.myjava.collection.generic;

public class GenericDemo3 {

    public static void main(String[] args) {
        InterImpl in = new InterImpl();
        in.show("abcc");

        InterImpl2<Integer> in2 = new InterImpl2<Integer>();
        in2.show(5);
    }

}

// 泛型接口，将泛型定义在接口上
interface Inter<T> {
    public void show(T t);
}

class InterImpl implements Inter<String> {
    @Override
    public void show(String str) {
        System.out.println("show:" + str);
    }
}

class InterImpl2<Q> implements Inter<Q> {

    @Override
    public void show(Q t) {
        System.out.println("show:" + t);
    }
}
