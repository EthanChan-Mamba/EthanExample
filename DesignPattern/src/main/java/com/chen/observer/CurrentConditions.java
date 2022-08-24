package com.chen.observer;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName CurrentConditions.java
 * @Description 显示当前天气情况，气象站自己网站
 * @createTime 2022-05-22 14:25
 */
public class CurrentConditions {
    // 温度，气压，湿度
    private float temperature;
    private float pressure;
    private float humidity;

    // 更新天气，由weatherData调用，使用推送
    public void update(float temperature, float pressure, float humidity) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        display();
    }

    public void display() {
        System.out.println(this.temperature + ";" + this.pressure + ";" + this.humidity);
    }
}
