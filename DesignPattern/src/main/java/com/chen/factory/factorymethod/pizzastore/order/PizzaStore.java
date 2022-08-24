package com.chen.factory.factorymethod.pizzastore.order;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName PizzaStore.java
 * @Description 工厂方法模式
 * @createTime 2022-04-23 21:34
 */
public class PizzaStore {
    public static void main(String[] args) {
        // 创建北京Pizza
        new BJOrderPizza();

        String loc = "bj";
        if ("bj".equals(loc)) {
            new BJOrderPizza();
        } else if ("ld".equals(loc)) {
            new LDOrderPizza();
        }

    }
}
