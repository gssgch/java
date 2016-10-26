package com.myjava.enumeration;

public abstract class WeekDay1 {

    private WeekDay1() {
    };

    public final static WeekDay1 SUN = new WeekDay1() {

        @Override
        public WeekDay1 nextDay() {
            return MON;
        }

    };
    public final static WeekDay1 MON = new WeekDay1() {

        @Override
        public WeekDay1 nextDay() {
            return SUN;
        }

    };

    // 采用抽象方法，可以将大量的ifelse语句转移成了一个个独立的类。
    // 如果想在一个类中编写完各个枚举类多和测试调用类，那么可以将枚举类定义成调用类的内部类。
    public abstract WeekDay1 nextDay();

    /*  这是一种方法，另外一种：让类和方法都是抽象的，使用内部类产生每个对象各自的nextDay方法。
    // 使用两个举例练习
    public final static WeekDay SUN = new WeekDay();
    public final static WeekDay MON = new WeekDay();
    //    public final static WeekDay TUE = new WeekDay();
    //    public final static WeekDay WED = new WeekDay();
    //    public final static WeekDay THU = new WeekDay();
    //    public final static WeekDay FRI = new WeekDay();
    //    public final static WeekDay SAT = new WeekDay();
    public WeekDay netDay() {
        if (this == SUN) {
            return MON;
        } else {
            return SUN;
        }
    }*/

    @Override
    public String toString() {
        return this == SUN ? "SUN" : "MON";
    }
}
