package itacademy.observer.java_implementation;


import itacademy.observer.java_implementation.observable.WeatherData;
import itacademy.observer.java_implementation.observers.CurrentConditionsDisplay;
import itacademy.observer.java_implementation.observers.ForecastDisplay;
import itacademy.observer.java_implementation.observers.HeatIndexDisplay;
import itacademy.observer.java_implementation.observers.StatisticDisplay;

public class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        CurrentConditionsDisplay currentConditionsDisplay
                = new CurrentConditionsDisplay(weatherData);
        ForecastDisplay forecastDisplay
                = new ForecastDisplay(weatherData);
        StatisticDisplay statisticDisplay
                = new StatisticDisplay(weatherData);
        HeatIndexDisplay heatIndexDisplay
                = new HeatIndexDisplay(weatherData);

        weatherData.setMeasurements
                (22.2f,22.2f,22.2f);
        weatherData.setMeasurements
                (44.4f,44.4f,44.4f);
        weatherData.deleteObserver(currentConditionsDisplay);
        weatherData.setMeasurements
                (33.3f,33.3f,33.3f);
    }
}
