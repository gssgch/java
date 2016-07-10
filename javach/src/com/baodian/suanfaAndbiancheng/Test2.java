package com.baodian.suanfaAndbiancheng;

import java.util.HashMap;
import java.util.Set;

//一串字符，有数字，字母，汉字，分别统计各个字符的数量，假定字符串中没有除数字，字母，汉字外的其他特殊字符
public class Test2 {

    public static void main(String[] args) {
        new Test2().count();//可用
        //		new Test2().count2();//有问题
    }

    public void count() {
        String str = "aaabc1212345找到好工作";
        int englishCount = 0;
        int chineseCount = 0;
        int digitCount = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if ((ch >= '0') && (ch <= '9')) {
                digitCount++;
            } else if (((ch >= 'a') && (ch <= 'z')) || ((ch >= 'A') && (ch <= 'Z'))) {
                englishCount++;
            } else {
                chineseCount++;
            }
        }
        System.out.println("字母：" + englishCount + ",汉字：" + chineseCount + ",数字：" + digitCount);
    }

    //这个方法有问题  ，
    public void count2() {
        String content = "吃货123伤不abcc起#￥%";
        HashMap map = new HashMap();
        for (int i = 0; i < content.length(); i++) {
            char c = content.charAt(i);
            Integer num = (Integer) map.get(c);
            if (num == null) {
                num = 1;
            } else {
                num += 1;
            }
            map.put(c, num);
        }

        //		for(Map.EntrySet entry:map){
        //			System.out.println(entry.getKey()+"//"+entry.getValue());
        //		}
        Set set = map.keySet();
        //		Iterator i=set.iterator();
        //		while(i.hasNext()){
        ////			String key=(String) i.next();
        ////			String value=(String) map.get(i.next());
        //			System.out.println(i.next()+"-->"+map.get(i.next()));
        //		}
    }
}
