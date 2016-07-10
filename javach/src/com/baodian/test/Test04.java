package com.baodian.test;

//try{}里面有一个return语句，紧跟在其后的finally{}里的代码会执行，准确的说是在return中间执行
public class Test04 {

    public static void main(String[] args) {

        new Test04();
        System.out.println(Test04.test());
    }

    static int test() {
        int x = 1;
        try {
            return x;
        } finally {
            ++x;
        }
    }

}
