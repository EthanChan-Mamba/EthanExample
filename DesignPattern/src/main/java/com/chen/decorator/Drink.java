package com.chen.decorator;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName Drink.java
 * @Description TODO
 * @createTime 2022-05-04 23:47
 */
public abstract class Drink {
    // 描述
    private String des;

    private float price = 0.00f;

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    // 计算费用的抽象方法
    // 子类实现
    public abstract float cost();
}
