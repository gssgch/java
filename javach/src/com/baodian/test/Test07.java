package com.baodian.test;

//如何倒叙输出Integer值
public class Test07 {

    public static void main(String[] args) {
        method1(12345678);
    }

    //方法一
    public static void method1(Integer n) {

        String ns = n.toString();
        String sz[] = new String[ns.length()];
        StringBuffer b = new StringBuffer();
        for (int i = ns.length(); i > 0; i--) {
            int j = 0;
            sz[j] = ns.substring(i - 1, i);
            b.append(sz[j]);
            j++;
        }
        System.out.println(b.toString());

    }

}
