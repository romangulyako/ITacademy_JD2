package itacademy.observer.java_implementation.observers;

import itacademy.observer.java_implementation.observable.WeatherData;
import itacademy.observer.own_implementation.api.DisplayElement;

import java.util.Observable;
import java.util.Observer;


public class StatisticDisplay implements Observer, DisplayElement {
    private float maxTemp = 0.0f;
    private float minTemp = 200;
    private float tempSum= 0.0f;
    private int numReadings;

    public StatisticDisplay(Observable observable) {
       observable.addObserver(this);
    }

    @Override
    public void display() {
        System.out.println("Средняя температура: " + (tempSum / numReadings));
        System.out.println("Максимальная температура: " + maxTemp);
        System.out.println("Минимальная температура: " + minTemp);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherData) {
            WeatherData weatherData = (WeatherData) o;
            float temperature = weatherData.getTemperature();
            tempSum += temperature;
            numReadings++;

            if (temperature > maxTemp) {
                maxTemp = temperature;
            }

            if (temperature < minTemp) {
                minTemp = temperature;
            }

            display();
        }
    }
}
