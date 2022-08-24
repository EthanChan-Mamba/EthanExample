package com.ethanChan.observer.improve;


/**
 * @author chen
 * @version 1.0.0
 * @ClassName Subject.java
 * @Description 让WeatherData实现
 * @createTime 2022-05-22 16:20
 */
public interface Subject {
    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObservers();
}
