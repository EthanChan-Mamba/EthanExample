package com.chen.observer;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName WeatherData.java
 * @Description 1.最新天气数据
 * 2.含有CurrentConditions
 * 3.数据更新，主动调用CurrentConditions.update，接入方看到最新数据
 * @createTime 2022-05-22 14:29
 */
public class WeatherData {

    private float temperature;
    private float pressure;
    private float humidity;
    private CurrentConditions currentConditions;

    public WeatherData(CurrentConditions currentConditions) {
        this.currentConditions = currentConditions;
    }

    public float getTemperature() {
        return temperature;
    }

    public float getPressure() {
        return pressure;
    }

    public float getHumidity() {
        return humidity;
    }

    public void dataChange() {
        currentConditions.update(getTemperature(), getPressure(), getHumidity());
    }

    // 当数据更新时，调用setData
    public void setData(float temperature, float pressure, float humidity) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        // 将最新信息推送给接入方currentConditions
        dataChange();
    }
}
