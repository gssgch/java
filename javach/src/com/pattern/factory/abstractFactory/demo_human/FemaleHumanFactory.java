package com.pattern.factory.abstractFactory.demo_human;

public class FemaleHumanFactory extends AbstractHumanFactory {
    // 创建一个女性黑种人
    @Override
    public Human createBlackHuman() {
        return super.createHuman(HumanEnum.BlackFemaleHuman);
    }

    // 创建一个女性黄种人
    @Override
    public Human createYellowHuman() {
        return super.createHuman(HumanEnum.YellowFemaleHuman);
    }

    // 创建一个女性白种人
    @Override
    public Human createWhiteHuman() {
        return super.createHuman(HumanEnum.WhiteFemaleHuman);
    }
}
