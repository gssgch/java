package com.myjava.collection.news;

import java.util.HashMap;
import java.util.Map;

public class ForEachDemo {

    public static void main(String[] args) {
        // 可以使用高级for遍历map集合吗?不能直接用，但是可以将map转换成单列的set，就可以了

        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(2, "zhangs");
        map.put(21, "lisi");
        map.put(9, "wangws");
        for (Integer key : map.keySet()) {
            String value = map.get(key);
            System.out.println(key + ":" + value);

        }
        for (Map.Entry<Integer, String> me : map.entrySet()) {
            Integer key = me.getKey();
            String value = me.getValue();
            System.out.println(key + "::" + value);
        }
    }

}
