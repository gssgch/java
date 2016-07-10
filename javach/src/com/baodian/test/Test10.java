package com.baodian.test;

//
public class Test10 {

    // 杨辉三角
    public static void testYangHui() {
        int i, j, n = 6, l, r;
        int a[] = new int[9];

        for (i = 1; i <= n; i++) {
            l = 1;
            // System.out.print(" ");
            for (int b = 7 - i; b > 0; b--) {
                System.out.print("  ");
            }
            if (i > 1) {
                System.out.print(l + "  ");

            }
            for (j = 1; j <= i; j++) {
                r = a[j];
                a[j] = l + r; /* 每个数是上面两数之和 */
                l = r;
                System.out.print(a[j] + "  ");
            }
            System.out.println();
        }
    }

    public static void test() {
        String[][] aa = new String[3][2];
    }

    // 测试年份区间的闰年
    public static void year(int x, int y) {
        int i;
        for (i = x; i < y; i++) {
            if ((i % 4) == 0) {
                if ((i % 100) != 0) {
                    System.out.println(i + "年是闰年");
                } else if ((i % 400) == 0) {
                    System.out.println(i + "年是闰年");
                } else {
                    System.out.println(i + "年不是闰年");
                }
            } else {
                System.out.println(i + "年不是闰年");
            }

        }
    }

    public static void main(String[] args) {
        testYangHui();
        // year(2010,2020);
    }
}