package com.myjava.pattern.staticproxy;

// 接口实现类  wanYu  是yiFei的代理 
public class wanYu implements actress {

    private actress actre;

    //无参构造方法
    public wanYu() {//默认的，为胡一菲的代理人
        this.actre = new yiFei();
    }

    public wanYu(actress actress) { //当然，宛瑜 还可以是actress任何一个女演员的代理 ，但是必须是actress类型
        this.actre = actress;
    }

    @Override
    public void movie() {//代理人实力不足，但是可以让被代理人，如胡一菲上阵
        this.actre.movie();

    }

    @Override
    public void teleplay() {//代理人无需自己上阵，由胡一菲上场拍电视剧
        this.actre.teleplay();

    }

}
