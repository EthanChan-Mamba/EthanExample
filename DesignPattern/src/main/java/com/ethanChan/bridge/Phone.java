package com.ethanChan.bridge;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName Phone.java
 * @Description TODO
 * @createTime 2022-05-04 23:12
 */
public abstract class Phone {

    private Brand brand;

    public Phone(Brand brand) {
        this.brand = brand;
    }

    public void open() {
        this.brand.open();
    }

    public void close() {
        this.brand.close();
    }

    public void call() {
        this.brand.call();
    }
}
