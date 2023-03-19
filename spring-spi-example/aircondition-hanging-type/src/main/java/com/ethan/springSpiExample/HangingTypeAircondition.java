package com.ethan.springSpiExample;

/**
 * @ClassName HangingTypeAircondition.java
 * @Description 挂式空调
 * @Author chenyixian
 * @Version 1.0.0
 * @Date 2023-03-19 22:29
 */
public class HangingTypeAircondition implements IAircondition{
    @Override
    public String getType() {
        return "HangingType";
    }
    @Override
    public void turnOnOff() {
        System.out.println("挂式空调开关");
    }
    @Override
    public void adjustTemperature(int i) {
        System.out.println("挂式空调调节温度");
    }
    @Override
    public void changeModel(int i) {
        System.out.println("挂式空调更换模式");
    }
}
