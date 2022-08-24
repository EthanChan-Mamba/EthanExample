package com.chen.factory.factorymethod.pizzastore.pizza;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName Pizza.java
 * @Description TODO
 * @createTime 2022-04-23 21:22
 */
public abstract class Pizza {
    protected String name;

    public abstract void prepare();

    public void bake() {
        System.out.println(name + " baking");
    }

    public void cut() {
        System.out.println(name + " cutting");
    }

    public void box() {
        System.out.println(name + " boxing");
    }

    public void setName(String name) {
        this.name = name;
    }
}
