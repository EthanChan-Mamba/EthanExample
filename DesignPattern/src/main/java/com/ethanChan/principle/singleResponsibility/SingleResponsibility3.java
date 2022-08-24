package com.ethanChan.principle.singleResponsibility;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName SingleResponsibility1.java
 * @Description TODO
 * @createTime 2022-04-16 23:30
 */
public class SingleResponsibility3 {
    public static void main(String[] args) {
        Vehicle2 vehicle = new Vehicle2();
        vehicle.run("摩托车");
        vehicle.airRun("飞机");
        vehicle.waterRun("船");
    }
}

// 交通工具类
// 方式1
// 1. 没有对原来的类做大的修改，只是增加方法
// 2. 虽然没有在类遵守单一职责，但是在方法是遵守单一职责
class Vehicle2 {
    public void run(String vehicle) {
        System.out.println(vehicle + "在公路上运行");
    }
    public void airRun(String vehicle) {
        System.out.println(vehicle + "在天空上运行");
    }
    public void waterRun(String vehicle) {
        System.out.println(vehicle + "在水里运行");
    }
}
