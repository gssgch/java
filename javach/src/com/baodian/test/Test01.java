package com.baodian.test;

//异常处理中的return和finally使用
public class Test01 {

    public static void main(String[] args) {
        System.out.println(get());
    }

    public static int get() {
        int ret = 0;
        try {
            ret += 1;
            return ret;//在这里return了，还要执行以下finally语句
        } catch (Exception e) {
            ret += 10;
        } finally {
            ret += 100;
        }
        return ret;//这个地方没执行，如果try语句里面没有return,就会执行
    }
}
