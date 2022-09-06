package com.ethanChan.decorator;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName Decorator.java
 * @Description TODO
 * @createTime 2022-05-04 23:54
 */
public class Decorator extends Drink {

    private Drink obj;

    public Decorator(Drink obj) {
        this.obj = obj;
    }

    @Override
    public float cost() {
        // 自己价格 + 饮料价格
        return super.getPrice() + obj.cost();
    }

    @Override
    public String getDes() {
        // 自己描述 + 自己价格 + 被装饰者描述
        return super.getDes() + super.getPrice() + "&&" + obj.getDes();
    }

}
