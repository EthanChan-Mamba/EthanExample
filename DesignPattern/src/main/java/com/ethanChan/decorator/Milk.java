package com.ethanChan.decorator;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName Chocolate.java
 * @Description 具体装饰者
 * @createTime 2022-05-04 23:59
 */
public class Milk extends Decorator {
    public Milk(Drink obj) {
        super(obj);
        setDes("牛奶");
        setPrice(2.0f);
    }
}
