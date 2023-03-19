package com.ethan.springSpiExample;

/**
 * @ClassName VerticalTypeAircondition.java
 * @Description 立式空调
 * @Author chenyixian
 * @Version 1.0.0
 * @Date 2023-03-19 22:33
 */
public class VerticalTypeAircondition
        implements IAircondition{
    @Override
    public String getType() {
        return "VerticalType";
    }
    @Override
    public void turnOnOff() {
        System.out.println("立式空调开关");
    }
    @Override
    public void adjustTemperature(int i) {
        System.out.println("立式空调调节温度");
    }
    @Override
    public void changeModel(int i) {
        System.out.println("立式空调更换模式");
    }
}
