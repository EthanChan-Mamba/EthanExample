package com.ethanChan.decorator;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName Chocolate.java
 * @Description 具体装饰者
 * @createTime 2022-05-04 23:59
 */
public class Chocolate extends Decorator {
    public Chocolate(Drink obj) {
        super(obj);
        setDes("巧克力");
        setPrice(3.0f);
    }
}
