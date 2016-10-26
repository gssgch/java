package com.myjava.enumeration;

import java.util.Date;

public class EnumTest {

    public static void main(String[] args) {
        // 传统的方法
        //        WeekDay1 weekDay1 = WeekDay1.MON;
        //        System.out.println(weekDay1.toString());

        WeekDay weekDay2 = WeekDay.MON;
        System.out.println(weekDay2);
        System.out.println(weekDay2.name());
        System.out.println(weekDay2.ordinal()); // 位置 从0开始
        System.out.println(WeekDay.valueOf("SUN")); // 默认调用toString()方法
        System.out.println(WeekDay.valueOf("SUN").toString());
        System.out.println(WeekDay.values().length);

        new Date(30) {
        }; // 子类调用父类有参的构造方法。

    }

    public enum WeekDay {
        SUN(), MON(1), TUE, WED, THI, FRI, SAT; // 如果只有元素，那么不需要分号。如果元素之后还有，必须加分号

        // 括号中是创建对象时使用的构造方法。

        // 构造方法必须放在元素之后
        private WeekDay() {
            System.out.println("first");
        };

        private WeekDay(int day) {
            System.out.println("second");
        };

    }

    public enum TrafficLamp { // 交通灯
        RED(30) {
            @Override
            public TrafficLamp nextLamp() {
                return GREEN;
            }
        },
        GREEN(45) {
            @Override
            public TrafficLamp nextLamp() {
                return YELLOW;
            }
        },
        YELLOW(3) {
            @Override
            public TrafficLamp nextLamp() {
                return RED;
            }
        };
        public abstract TrafficLamp nextLamp();

        private int time;

        private TrafficLamp(int time) {
            this.time = time;
        }
    }
}
