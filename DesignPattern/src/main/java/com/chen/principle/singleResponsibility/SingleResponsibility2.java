package com.chen.principle.singleResponsibility;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName SingleResponsibility1.java
 * @Description TODO
 * @createTime 2022-04-16 23:30
 */
public class SingleResponsibility2 {
    public static void main(String[] args) {
        RoadVehicle roadVehicle = new RoadVehicle();
        AirVehicle airVehicle = new AirVehicle();
        WaterVehicle waterVehicle = new WaterVehicle();
        roadVehicle.run("摩托车");
        airVehicle.run("飞机");
        waterVehicle.run("船");
    }
}

// 交通工具类
// 方式2
// 1. 遵守单一职责原则
// 2.改动大，将类分解，同时修改客户端
// 3.方案3直接改Vehicle
class RoadVehicle {
    public void run(String vehicle) {
        System.out.println(vehicle + "在公路上运行");
    }
}

class AirVehicle {
    public void run(String vehicle) {
        System.out.println(vehicle + "在天上运行");
    }
}

class WaterVehicle {
    public void run(String vehicle) {
        System.out.println(vehicle + "在水上运行");
    }
}
