package com.myjava.pattern.clone;

import java.util.ArrayList;

public class Thing implements Cloneable {
    // 定义一个私有变量
    private ArrayList<String> arrayList = new ArrayList<String>();

    // clone 和final是一对冤家
    @SuppressWarnings("unused")
    private final ArrayList<String> arrayList2 = new ArrayList<String>();

    @Override
    public Thing clone() {
        Thing thing = null;
        try {
            // 浅拷贝
            thing = (Thing) super.clone();

            // 深拷贝
            thing.arrayList = (ArrayList<String>) this.arrayList.clone();

            // 属性里面定义了final之后，此处编译报错
            // thing.arrayList2 = (ArrayList<String>) this.arrayList2.clone();

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return thing;
    }

    // 设置HashMap的值
    public void setValue(String value) {
        this.arrayList.add(value);
    }

    // 取值
    public ArrayList<String> getValue() {
        return this.arrayList;
    }
}
