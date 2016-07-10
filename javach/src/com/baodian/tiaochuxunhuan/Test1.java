package com.baodian.tiaochuxunhuan;

public class Test1 {

    public static void main(String[] args) {
        //test1();
        //test2();
        test3();
    }

    //在内层循环体的代码中使用带有标号的break语句，跳出内层循环
    public static void test1() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.println("i:" + i + "\t" + "j:" + j);
                if (j == 5) {
                    break;
                }
            }
        }
    }

    public static void test2() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.println("i:" + i + "\t" + "j:" + j);
                if (j == 5) {
                    i = 3;
                    break;
                }
            }
        }
    }

    public static void test3() {
        try {

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 10; j++) {
                    System.out.println("i:" + i + "\t" + "j:" + j);
                    if (j == 5) {
                        throw new Exception();
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
