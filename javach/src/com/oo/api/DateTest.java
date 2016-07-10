package com.oo.api;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {

    public static void main(String[] args) throws ParseException {
        String str1 = "2012--3--17";
        String str2 = "2012--4--15";

        test(str1, str2);
    }

    public static void test(String str1, String str2) throws ParseException {
        DateFormat dateFormat = DateFormat.getDateInstance();
        dateFormat = new SimpleDateFormat("yyyy--MM-dd");
        Date date1 = dateFormat.parse(str1);
        Date date2 = dateFormat.parse(str2);
        long time1 = date1.getTime();
        long time2 = date2.getTime();
        long time = Math.abs(time1 - time2);
        System.out.println(getDay(time));
    }

    private static int getDay(long time) {
        return (int) time / 1000 / 60 / 60 / 24;
    }

}
