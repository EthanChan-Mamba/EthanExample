package com.chen.responsibilitychain;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName responsibilitychain.java
 * @Description TODO
 * @createTime 2022-05-29 13:40
 */
public class PurchaseRequest {
    private int type = 0;
    private float price = 0.0f;
    private int id = 0;

    public PurchaseRequest(int type, float price, int id) {
        this.type = type;
        this.price = price;
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public float getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }
}
