package com.ethanChan.observer.improve;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName Client.java
 * @Description TODO
 * @createTime 2022-05-22 16:29
 */
public class Client {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        CurrentConditions currentConditions = new CurrentConditions();

        weatherData.registerObserver(currentConditions);

        weatherData.setData(1, 1, 1);
    }
}
