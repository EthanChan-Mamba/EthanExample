package com.chen.bridge;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName FoldedPhone.java
 * @Description 折叠手机继承Phone
 * @createTime 2022-05-04 23:14
 */
public class FoldedPhone extends Phone {
    public FoldedPhone(Brand brand) {
        super(brand);
    }

    @Override
    public void open() {
        super.open();
        System.out.println("折叠手机开机");
    }

    @Override
    public void close() {
        super.close();
        System.out.println("折叠手机关机");
    }

    @Override
    public void call() {
        super.call();
        System.out.println("折叠手机打电话");
    }
}
