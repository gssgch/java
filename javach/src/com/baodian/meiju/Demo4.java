package com.baodian.meiju;

//用法四：覆盖枚举的方法
//下面给出一个toString()方法覆盖的例子。
public enum Demo4 {
    RED("红色", 1), GREEN("绿色", 2), BLANK("白色", 3), YELLO("黄色", 4);
    // 成员变量  
    private String name;
    private int index;

    // 构造方法  
    private Demo4(String name, int index) {
        this.name = name;
        this.index = index;
    }

    //覆盖方法  
    @Override
    public String toString() {
        return this.index + "_" + this.name;
    }

    public static void main(String[] args) {
        Demo4.RED.toString();
        System.out.println(Demo4.RED.toString());
    }
}
