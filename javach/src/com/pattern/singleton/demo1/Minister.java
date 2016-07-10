package com.pattern.singleton.demo1;

public class Minister {

    @SuppressWarnings("static-access")
    public static void main(String[] args) {

        // 第一天
        Emperor emperor1 = Emperor.getInstance();
        Emperor.emperorInfo();

        // 第二天
        Emperor emperor2 = Emperor.getInstance();
        Emperor.emperorInfo();

        // 第三天
        Emperor emperor3 = Emperor.getInstance();
        Emperor.emperorInfo();

        System.out.println(emperor1.hashCode());
        System.out.println(emperor2.hashCode());
        System.out.println(emperor1 == emperor2);
        System.out.println(emperor2.equals(emperor3));
    }
}
