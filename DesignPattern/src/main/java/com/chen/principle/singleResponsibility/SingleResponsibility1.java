package com.chen.principle.singleResponsibility;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName SingleResponsibility1.java
 * @Description TODO
 * @createTime 2022-04-16 23:30
 */
public class SingleResponsibility1 {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        vehicle.run("摩托车");
        vehicle.run("汽车");
        vehicle.run("飞机");
    }
}

// 交通工具类
// 方式1
// 1. 在方式1的run中，违法单一职责原则
// 2.解决方法，根据交通工具运行方法不同，分解成不同类
class Vehicle {
    public void run(String vehicle) {
        System.out.println(vehicle + "在公路上运行");
    }
}
