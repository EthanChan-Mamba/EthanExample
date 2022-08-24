package com.ethanChan.observer.improve;

import java.util.ArrayList;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName WeatherData.java
 * @Description 1.最新天气数据
 * 2.含有观察者集合
 * 3.数据更新，主动调用ArrayList，通知所有接入方看到最新数据
 * @createTime 2022-05-22 14:29
 */
public class WeatherData implements Subject {

    private float temperature;
    private float pressure;
    private float humidity;
    private ArrayList<Observer> observers;

    public WeatherData() {
        this.observers = new ArrayList<Observer>();
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
        notifyObservers();
    }

    // 当数据更新时，调用setData
    public void setData(float temperature, float pressure, float humidity) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        // 将最新信息推送给接入方currentConditions
        dataChange();
    }

    public void registerObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        if (observers.contains(o)) {
            observers.remove(o);
        }
    }

    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(this.temperature, this.pressure, this.humidity);
        }
    }
}
