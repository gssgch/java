package com.myjava.pattern.builderPattern.demo1;

import java.util.ArrayList;

public class Director {

    private ArrayList<String> sequence = new ArrayList();
    private BenzBuilder benzBuilder = new BenzBuilder();
    private BmwBuilder bmwBuilder = new BmwBuilder();

    // A类型的奔驰车模型，先start,再stop，
    public BenzModel getABenzModel() {
        this.sequence.clear();// 清理场景，这一步很重要
        this.sequence.add("start");
        this.sequence.add("stop");

        this.benzBuilder.setSequence(this.sequence);
        return (BenzModel) this.benzBuilder.getCarModel();
    }

    // B型号的奔驰车模型，先引擎，再启动，再停止
    public BenzModel getBBenzModel() {
        this.sequence.clear();
        this.sequence.add("engineBoom");
        this.sequence.add("start");
        this.sequence.add("stop");
        this.benzBuilder.setSequence(this.sequence);
        return (BenzModel) this.benzBuilder.getCarModel();
    }

    // c型号的宝马车

    public BmwModel getCBModel() {
        this.sequence.clear();
        this.sequence.add("alarm");
        this.sequence.add("start");
        this.sequence.add("stop");
        this.bmwBuilder.setSequence(this.sequence);
        return (BmwModel) this.bmwBuilder.getCarModel();
    }
}
