package itacademy.observer.own_implementation.observers;

import itacademy.observer.own_implementation.api.DisplayElement;
import itacademy.observer.own_implementation.api.Observer;
import itacademy.observer.own_implementation.api.Subject;

public class CurrentConditionsDisplay implements Observer, DisplayElement {
    private float temperature;
    private float humidity;
    private float pressure;

    public CurrentConditionsDisplay(Subject weatherData) {
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("Текущая погода:");
        System.out.println("Температура: " + this.temperature);
        System.out.println("Влажность: " + this.humidity);
        System.out.println("Давление: " + this.pressure);
    }


    @Override
    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        display();
    }
}
