package com.chen.decorator;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName Chocolate.java
 * @Description 具体装饰者
 * @createTime 2022-05-04 23:59
 */
public class Soy extends Decorator {
    public Soy(Drink obj) {
        super(obj);
        setDes("豆浆");
        setPrice(2.0f);
    }
}
