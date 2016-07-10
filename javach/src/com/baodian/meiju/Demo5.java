package com.baodian.meiju;

//用法五：实现接口
//所有的枚举都继承自java.lang.Enum类。由于Java 不支持多继承，所以枚举对象不能再继承其他类。 
public enum Demo5 implements Behaviour {
    RED("红色", 1), GREEN("绿色", 2), BLANK("白色", 3), YELLO("黄色", 4);
    // 成员变量  
    private String name;
    private int index;

    // 构造方法  
    private Demo5(String name, int index) {
        this.name = name;
        this.index = index;
    }

    //接口方法  
    @Override
    public String getInfo() {
        return this.name;
    }

    //接口方法  
    @Override
    public void print() {
        System.out.println(this.index + ":" + this.name);
    }

    public static void main(String[] args) {
        System.out.println(Demo5.GREEN.getInfo());
        Demo5.YELLO.print();
    }
}