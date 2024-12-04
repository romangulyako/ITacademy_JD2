package itacademy.observer.own_implementation.observers;

import itacademy.observer.own_implementation.api.DisplayElement;
import itacademy.observer.own_implementation.api.Observer;
import itacademy.observer.own_implementation.subjects.WeatherData;

public class StatisticDisplay implements Observer, DisplayElement {
    private float maxTemp = 0.0f;
    private float minTemp = 200;
    private float tempSum= 0.0f;
    private int numReadings;

    public StatisticDisplay(WeatherData weatherData) {
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("Средняя температура: " + (tempSum / numReadings));
        System.out.println("Максимальная температура: " + maxTemp);
        System.out.println("Минимальная температура: " + minTemp);
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
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
