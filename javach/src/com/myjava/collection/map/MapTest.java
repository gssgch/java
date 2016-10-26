package com.myjava.collection.map;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/*
 * 练习：获取字符串中每一个字母出现的次数    “sadfssuerqenv”
 * 要求打印结果是：a(2)b(1)....
 */
public class MapTest {

    public static void main(String[] args) {
        String str = "sa121dfssdf45xsuEEe-DTrqenv";
        //将字符串变成字符数组
        char[] chas = str.toCharArray();
        Map<Character, Integer> map = new TreeMap<Character, Integer>();
        for (int i = 0; i < chas.length; i++) {
            if (!(((chas[i] >= 'a') && (chas[i] <= 'z')) || ((chas[i] >= 'A') && (chas[i] <= 'Z')))) {
                continue;
            }
            // 将数组中的字母作为键去查map表
            Integer value = map.get(chas[i]);
            // 判断值是否为null
            /* if (value == null) {
                 map.put(chas[i], 1);
             } else {
                 map.put(chas[i], value + 1);
             }*/

            // 改进代码
            int count = 1;
            if (value != null) {
                count = value + 1;
            }
            map.put(chas[i], count);
        }
        System.out.println(mapToString(map));
    }

    public static String mapToString(Map<Character, Integer> map) {
        StringBuffer sb = new StringBuffer();
        Iterator<Character> it = map.keySet().iterator();
        while (it.hasNext()) {
            Character key = it.next();
            Integer value = map.get(key);
            sb.append(key + "(" + value + ")");
        }
        return sb.toString();

    }

}
