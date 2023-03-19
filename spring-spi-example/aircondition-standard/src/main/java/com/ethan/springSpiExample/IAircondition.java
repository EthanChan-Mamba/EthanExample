package com.ethan.springSpiExample;

/**
 * @ClassName IAircondition.java
 * @Description 空调
 * @Author chenyixian
 * @Version 1.0.0
 * @Date 2023-03-19 22:26
 */
public interface IAircondition {
    // 获取型号
    String getType();

    // 开关
    void turnOnOff();

    // 调节温度
    void adjustTemperature(int temperature);

    // 模式变更
    void changeModel(int modelId);
}
