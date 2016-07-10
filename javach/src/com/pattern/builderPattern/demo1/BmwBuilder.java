package com.pattern.builderPattern.demo1;

import java.util.ArrayList;

public class BmwBuilder extends CarBuilder {

    private BmwModel Bmw = new BmwModel();

    @Override
    public CarModel getCarModel() {
        return this.Bmw;
    }

    @Override
    public void setSequence(ArrayList<String> sequence) {
        this.Bmw.setSequence(sequence);
    }

}
