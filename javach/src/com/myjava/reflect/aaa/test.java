package com.myjava.reflect.aaa;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class test {
    /*
         在JDK中，主要由以下类来实现Java反射机制，这些类都位于java.lang.reflect包中
      Class类：代表一个类。
      Field 类：代表类的成员变量（成员变量也称为类的属性）。
      Method类：代表类的方法。
      Constructor 类：代表类的构造方法。
      Array类：提供了动态创建数组，以及访问数组的元素的静态方法
    */

    /*
    例程ReflectTester 类进一步演示了Reflection API的基本使用方法。
    ReflectTester类有一个copy(Object object)方法，这个方法能够创建一个和参数object 同样类型的对象，
    然后把object对象中的所有属性拷贝到新建的对象中，并将它返回 
    这个例子只能复制简单的JavaBean，假定JavaBean 的每个属性都有public 类型的getXXX()和setXXX()方法。
    */

    /*Class类是Reflection API 中的核心类，它有以下方法
      getName()：获得类的完整名字。
      getFields()：获得类的public类型的属性。
      getDeclaredFields()：获得类的所有属性。
      getMethods()：获得类的public类型的方法。
      getDeclaredMethods()：获得类的所有方法。
    */

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception {

        /*
        Class c0=Object.class.getClass();
        System.out.println(c0); //结果 class java.lang.Class 
        
        Class inte=Class.forName("com.myjava.reflect.inte1");
        System.out.println(inte);//结果是  interface com.myjava.reflect.inte1
        */

        Class c1 = Class.forName("com.myjava.reflect.stu");
        //Class是一个类，通过.forName(className)方法，创建了一个Class类的对象c1

        System.out.println("1:" + c1); //结果是class  com.myjava.reflect.stu
        //通过.forName()方法得到了一个Class对象，该对象包含了stu类的所有属性和方法
        System.out.println("类的全名：" + c1.getName());

        Field[] f1 = c1.getFields();//获得类的public类型的属性
        for (Field ff : f1) {
            System.out.println("类的public属性：" + ff.getName());
        }

        Field[] f2 = c1.getDeclaredFields(); //获得类的所有属性
        for (Field ff : f2) {
            System.out.println("类的所有属性：" + ff.getName());
        }

        Method[] me = c1.getDeclaredMethods();//获取类的所有方法   public 和private 不包括构造方法
        for (Method m : me) {
            System.out.println("类的所有方法：" + m.getName() + "\t方法全名为 ：\t" + m.toString());
        }

        Method[] m2 = c1.getMethods();//获取类的public方法
        for (Method m : m2) {
            System.out.println("类的public方法：" + m.getName() + "\t方法全名为 ：\t" + m.toString());
            //public方法还有很多自带的方法！
        }

        Constructor[] con1 = c1.getConstructors();//获取类的public类型的构造方法
        for (Constructor c : con1) {
            System.out.println("类的public构造方法：" + c + "\t 构造方法全名：" + c.getName());
        }

        Constructor[] cons2 = c1.getDeclaredConstructors();//获取类的所有构造方法
        for (Constructor c : cons2) {
            System.out.println("类的所有构造方法:" + c + "\t构造方法全名：" + c.getName());
            //得到所有的构造方法和构造方法全名(和类名一样)
        }

        //getConstructor(Class[] parameterTypes)：获得类的特定构造方法，parameterTypes 参数指定构造方法的参数类型。
        Constructor cons3 = c1.getConstructor(new Class[] { String.class,
                int.class });
        System.out.println("指定的构造方法:" + cons3);//得到参数为string类型和int类型的构造方法

        //newInstance()：通过类的不带参数的构造方法创建实例
        stu s1 = (stu) c1.newInstance();
        //s1.setAge(10);  //对象定义的时候已经赋有值，此处可以再次赋值
        System.out.println("年龄:" + s1.getAge());
        stu sss = s1;
        System.out.println(sss.getAge());

        //通过有参构造方法创建实例	 注意：有参的构造方法需要通过getConstructor(Class[] parameterTypes)获取
        stu s2 = (stu) cons3.newInstance("张三", 12);//通过上面指定的构造方法new一个对象
        System.out.println("姓名：" + s2.getName() + "\t年龄：" + s2.getAge());

        /*getMethod(String name, Class[] parameterTypes)：
              获得类的特定方法，name参数指定方法的名字，parameterTypes 参数指定方法的参数类型
          */
        Method oneAddTwo = c1.getMethod("oneJiaTwo", new Class[] { int.class,
                int.class });
        //调用方法 ，赋值 ，获取结果
        Object result = oneAddTwo.invoke(s2, new Object[] { 3, 5 });
        //这个地方s1和s2都可以用，因为不管是通过无参构造方法创建的实例还是通过有参构造方法创建的实例，都可以用来调用oneAddTwo这个方法
        System.out.println("结果：" + result);
        /*Method类的invoke(Object obj,Object args[])方法接收的参数必须为对象，
         如果参数为基本类型数据，必须转换为相应的包装类型的对象。invoke()方法的返回值总是对象，
        如果实际被调用的方法的返回类型是基本类型数据,那么invoke()方法会把它转换为相应的包装类型的对象，再将其返回
         */

    }
}
