package itacademy.observer.own_implementation.observers;

import itacademy.observer.own_implementation.api.DisplayElement;
import itacademy.observer.own_implementation.api.Observer;
import itacademy.observer.own_implementation.subjects.WeatherData;

public class ForecastDisplay implements Observer, DisplayElement {
    private float currentTemperature = 29.92f;
    private float lastTemperature;

    public ForecastDisplay(WeatherData weatherData) {
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.print("Прогноз: ");
        if (currentTemperature > lastTemperature) {
            System.out.println("Погода улучшается!");
        } else if (currentTemperature == lastTemperature) {
            System.out.println("Погода прежняя");
        } else if (currentTemperature < lastTemperature) {
            System.out.println("Холодает");
        }
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        this.lastTemperature = this.currentTemperature;
        this.currentTemperature = temperature;
        display();
    }
}
