package com.myjava.collection.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapDemo {

    public static void main(String[] args) { // LinkedHashMap 有序
        HashMap<Integer, String> hm = new LinkedHashMap<Integer, String>();

        hm.put(5, "zhangsan");
        hm.put(3, "jack");
        hm.put(9, "mike");
        hm.put(1, "lisi");

        Iterator<Map.Entry<Integer, String>> it = hm.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, String> me = it.next();
            Integer key = me.getKey();
            String value = me.getValue();
            System.out.println(key + "----" + value);
        }
    }

}
