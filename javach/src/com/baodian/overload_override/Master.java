package com.baodian.overload_override;

public class Master {

    private String name;

    public Master() {

    }

    public Master(String name) {
        this.name = name;
    }

    public void train(Dog dog) {
        System.out.println(dog.getColor() + "的" + dog.getName() + "向主人摇尾巴！");
        System.out.println(dog.getColor() + "的" + dog.getName() + "接飞盘");
    }

    public void train(Monkey monkey) {
        System.out.println(monkey.getColor() + "的" + monkey.getName() + "伸手要食物！");
        System.out.println(monkey.getColor() + "的" + monkey.getName() + "在爬树！");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
