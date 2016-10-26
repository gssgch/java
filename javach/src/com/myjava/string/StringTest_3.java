package com.myjava.string;

public class StringTest_3 {

    public static void main(String[] args) {

        String s1 = "qwertabcdaaafyle";
        String s2 = "abcdexcabeedg";
        String s = getMaxSubstring(s1, s2);
        System.out.println("s=" + s);
    }

    /**
     * 获取最大子串
     * @param s1
     * @param s2
     * @return
     */
    public static String getMaxSubstring(String s1, String s2) {
        String max = null, min = null;
        max = (s1.length() > s2.length()) ? s1 : s2;
        min = max.equals(s1) ? s2 : s1;
        System.out.println("max:" + max);
        System.out.println("min:" + min);

        for (int i = 0; i < min.length(); i++) {
            for (int a = 0, b = min.length() - i; b != (min.length() + 1); a++, b++) {
                String sub = min.substring(a, b);
                if (max.contains(sub)) {
                    return sub;
                }
            }
        }
        return null;
    }
}
