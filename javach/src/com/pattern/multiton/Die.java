package com.pattern.multiton;

import java.util.Date;
import java.util.Random;

//多例模式
public class Die {

    private static Die die1 = new Die();
    private static Die die2 = new Die();

    private Die() {

    }

    public static Die getInstance(int whichOne) {
        if (whichOne == 1) {
            return die1;
        } else {
            return die2;
        }
    }

    // 掷骰子，返回一个1-6之间的随机数
    public synchronized int dice() {
        Date date = new Date();
        Random r = new Random(date.getTime());
        int value = r.nextInt();
        value = Math.abs(value);
        value += 1;
        return value;
    }
}
