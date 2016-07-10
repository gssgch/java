package com.collection.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/*
 * map集合获取键值对的两种方法
 */
public class MapDemo {

    public static void main(String[] args) {

        getMethod1();
        //        getMethod2();
    }

    // values 方法获取所有的值
    public static void getMethod3() {
        Map<Integer, String> map = new HashMap<Integer, String>();

        map.put(1, "zhangsan");
        map.put(2, "lisi");
        map.put(3, "wangwu");
        map.put(5, "wangcai");
        Collection<String> values = map.values();
        Iterator it = values.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    /*
     *通过Map转成set就可以迭代。
     *使用entrySet.该方法将键和值的映射关系作为对象存储到了Set集合中，而这个映射关系的类型就是Map.entrySet类型。
     */
    public static void getMethod2() { // entrySet
        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(1, "zhangsan");
        map.put(2, "lisi");
        map.put(3, "wangwu");
        map.put(5, "wangcai");
        Set<Map.Entry<Integer, String>> entrySet = map.entrySet(); // 内部接口
        Iterator<Entry<Integer, String>> it = entrySet.iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, String> mm = it.next();
            Integer key = mm.getKey();
            String value = mm.getValue();
            System.out.println("key:" + key + "---value:" + value);
        }
    }

    public static void getMethod1() { //keySet
        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(1, "zhangsan");
        map.put(2, "lisi");
        map.put(3, "wangwu");
        map.put(5, "wangcai");
        Set keySet = map.keySet();
        Iterator it = keySet.iterator();
        while (it.hasNext()) {
            Integer key = (Integer) it.next();
            String value = map.get(key);
            System.out.println("key:" + key + "---value:" + value);
        }
    }
}
