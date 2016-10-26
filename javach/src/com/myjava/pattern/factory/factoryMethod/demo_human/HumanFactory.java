package com.myjava.pattern.factory.factoryMethod.demo_human;

import java.util.List;
import java.util.Random;

//然后看我们的程序修改，先修改HumanFactory.java，增加了createHuman()方法：
public class HumanFactory {

    // 定一个烤箱，泥巴塞进去，人就出来，这个太先进了
    public static Human createHuman(Class c) {
        Human human = null; // 定义一个类型的人类
        try {
            human = (Human) Class.forName(c.getName()).newInstance();
            // 产生一个
        } catch (InstantiationException e) {
            // 你要是不说个人类颜色的话，没法烤，要白的
            System.out.println("必须指定人类的颜色");
        } catch (IllegalAccessException e) {
            // 定义的人类有问题，那就烤不出来了，这是...
            System.out.println("人类定义错误！");
        } catch (ClassNotFoundException e) {
            // 你随便说个人类，我到哪里给你制造去？！
            System.out.println("混蛋，你指定的人类找不到！");
        }
        return human;
    }

    // 女娲生气了，把一团泥巴塞到八卦炉，哎产生啥人类就啥人类
    public static Human createHuman() {
        Human human = null; // 定义一个类型的人类
        // 首先是获得有多少个实现类，多少个人类
        List<Class> concreteHumanList = ClassUtils.getAllClassByInterface(Human.class); // 定义了多少人类
        // 八卦炉自己开始想烧出什么人就什么人
        Random random = new Random();
        int rand = random.nextInt(concreteHumanList.size());
        human = createHuman(concreteHumanList.get(rand));
        return human;
    }
    /**
     * 我们来总结一下，特别是增加了createHuman()后，是不是这个工厂的扩展性更好了？你看你要再加一 个人类，只要你继续集成Human
     * 接口成了，然后啥都不用修改就可以生产了，具体产多少，那要八卦炉说
     * 了算，简单工厂模式就是这么简单，那我们再引入一个问题：人是有性别的呀，有男有女，你这怎么没区 别，别急，这个且听下回分解！
     * 工厂方法模式还有一个非常重要的应用，就是延迟始化(Lazy initialization)，什么是延迟始化呢？
     * 一个对象初始化完毕后就不释放，等到再次用到得就不用再次初始化了，直接从内存过中拿到就可以了， 怎么实现呢，很简单，看例子：
     */

    /**
     * public class HumanFactory { //定义一个MAP,初始化过的Human对象都放在这里 private static
     * HashMap<String,Human> humans = new HashMap<String,Human>();
     * //定一个烤箱，泥巴塞进去，人就出来，这个太先进了 public static Human createHuman(Class c){ Human
     * human=null; //定义一个类型的人类 try { //如果MAP中有，则直接从取出，不用初始化了
     * if(humans.containsKey(c.getSimpleName())){ human =
     * humans.get(c.getSimpleName()); }else{ human =
     * (Human)Class.forName(c.getName()).newInstance(); //放到MAP中
     * humans.put(c.getSimpleName(), human); } } catch (InstantiationException
     * e) {//你要是不说个人类颜色的话，没法烤，要白的 System.out.println("必须指定人类的颜色"); } catch
     * (IllegalAccessException e) { //一定定义的人类有问题，那就烤不出来了，
     * System.out.println("人类定义错误！"); } catch (ClassNotFoundException e) {
     * //你随便说个人类，我到哪里给你制造去？！ System.out.println("混蛋，你指定的人类找不到！"); } return
     * human; } }
     */

    /*
     * 很简单，就加上了黄色那部分的代码，这个在类初始化很消耗资源的情况比较实用，比如你要连接硬
     * 件，或者是为了初始化一个类需要准备比较多条件（参数），通过这种方式可以很好的减少项目的复杂程度。
     */

}
