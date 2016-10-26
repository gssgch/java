package com.myjava.javacode.test;

import java.math.BigInteger;

/**
 * @see
 */
public class Test_ifelse {

    /**
     * @param args
     */
    public static void main(String[] args) {
        test_if(0);
    }

    public static void test_if(int x) {
        int sign;
        //  if(x<=0) if(x>0) sign=0;else sign=1;
        //else子句与最邻近的if构成一组，加上花括号，代码层次更明显，如果x>0,括号内的代码不会执行了
        if (x <= 0) {
            if (x > 0) {
                sign = 0;
            } else {
                sign = 1;
            }
            System.out.println(sign);
        }

    }

    public static void bigIntegr() {
        // 通过valueOf转换值
        BigInteger a = BigInteger.valueOf(1000);
        // add multiply
        BigInteger b = BigInteger.valueOf(100);

        BigInteger c = a.add(b); // c=a+b

        BigInteger d = a.multiply(c.add(b)); // d=a * (c+b)

    }

}
