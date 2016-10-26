package com.myjava.reflect.base;

public class ReflectDemo {

    public static void main(String[] args) throws Exception {
        //        getClassObject_1();
        //        getClassObject_2();
        getClassObject_3();
        Class st1 = String.class;
        System.out.println(st1.isPrimitive());
        System.out.println(void.class.isPrimitive());
    }

    /*
     * 方法3：
     * 只要通过给定的类的字符串名称就可以获取该类，更为扩展。
     * 可以用Class类中的方法完成。
     * 该方法就是forName.
     *
     * 这种方式只要有名称即可， 更为方便，扩展性更强
     */
    public static void getClassObject_3() throws Exception {
        String className = "com.myjava.reflect.base.Person";
        Class clazz = Class.forName(className);
    }

    /*
     * 方法二：
     * 2，任何数据类型都具备的一个静态属性.class来获取其对应的Class对象
     * 相对简单，但是还是要明确用到类中的静态成员。
     * 还是不够扩展
     */
    public static void getClassObject_2() {
        Class clazz = Person.class;
        Class clazz2 = Person.class;
        System.out.println("clazz==clazz2:" + (clazz == clazz2));

    }

    /*
     * 获取字节码对象的方式：
     * 1，Object类中的getClass方法
     */
    public static void getClassObject_1() {
        Person p = new Person();
        Class clazz = p.getClass();
        Person p1 = new Person();
        Class clazz1 = p.getClass();
        System.out.println("clazz==clazz1:" + (clazz == clazz1));
    }

}
