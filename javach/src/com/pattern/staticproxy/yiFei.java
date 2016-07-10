package com.pattern.staticproxy;

//接口实现类   胡一菲
public class yiFei implements actress {

    @Override
    public void movie() {
        System.out.println("胡一菲要拍电影《东方不败重出江湖》");
    }

    @Override
    public void teleplay() {
        System.out.println("胡一菲接拍电视剧《爱情公寓4》");

    }
}
