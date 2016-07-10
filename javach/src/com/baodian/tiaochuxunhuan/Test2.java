package com.baodian.tiaochuxunhuan;

public class Test2 {

    public static void main(String[] args) {

        int arr[][] = { { 1, 2, 3 }, { 4, 5, 6, 7 }, { 9 } };
        boolean flag = false;
        for (int i = 0; (i < arr.length) && !flag; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.println("i=" + i + ",j=" + j);
                if (arr[i][j] == 5) {
                    flag = true;
                    break;
                }
            }
        }

    }
    //对于跳出循环，更好的 方法是
    //让外层循环表达式的结果可以受到里层循环体代码的控制，例如要在二维代码中查找某个数字

}
