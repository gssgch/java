package com.baodian.meiju;

//用法二：switch
//JDK1.6之前的switch语句只支持int,char,enum类型，使用枚举，能让我们的代码可读性更强。
public class Demo2 {

    public static void main(String[] args) {
        new Demo2().change();
    }

    Signal color = Signal.RED;

    public void change() {
        System.out.println(color);
        switch (color) {
            case RED:
                color = Signal.RED;
                break;
            case YELLOW:
                color = Signal.YELLOW;
                break;
            case GREEN:
                color = Signal.GREEN;
                break;
        }
    }
}

enum Signal {
    GREEN, YELLOW, RED
}