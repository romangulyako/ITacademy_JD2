package itacademy.observer.java_implementation.observers;

import itacademy.observer.java_implementation.observable.WeatherData;
import itacademy.observer.own_implementation.api.DisplayElement;

import java.util.Observable;
import java.util.Observer;

public class ForecastDisplay implements Observer, DisplayElement {
    private float currentTemperature = 29.92f;
    private float lastTemperature;

    public ForecastDisplay(Observable observable) {
        observable.addObserver(this);
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
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherData) {
            this.lastTemperature = this.currentTemperature;
            this.currentTemperature = ((WeatherData) o).getTemperature();
            display();
        }
    }
}
