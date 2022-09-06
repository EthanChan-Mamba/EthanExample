package com.ethanChan.observer;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName Client.java
 * @Description TODO
 * @createTime 2022-05-22 14:33
 */
public class Client {
    public static void main(String[] args) {
        // 接入方
        CurrentConditions currentConditions = new CurrentConditions();

        // 设置接入方
        WeatherData weatherData = new WeatherData(currentConditions);
        weatherData.setData(1, 1, 1);
    }
}
