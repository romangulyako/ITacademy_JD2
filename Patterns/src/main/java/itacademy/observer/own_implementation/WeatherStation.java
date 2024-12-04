package itacademy.observer.own_implementation;

import itacademy.observer.own_implementation.observers.CurrentConditionsDisplay;
import itacademy.observer.own_implementation.observers.ForecastDisplay;
import itacademy.observer.own_implementation.observers.HeatIndexDisplay;
import itacademy.observer.own_implementation.observers.StatisticDisplay;
import itacademy.observer.own_implementation.subjects.WeatherData;

public class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentConditionsDisplay currentConditionsDisplay =
                new CurrentConditionsDisplay(weatherData);
        ForecastDisplay forecastDisplay =
                new ForecastDisplay(weatherData);
        StatisticDisplay statisticDisplay =
                new StatisticDisplay(weatherData);
        HeatIndexDisplay heatIndexDisplay =
                new HeatIndexDisplay(weatherData);

        weatherData.setMeasurements
                (22.2f,22.2f,22.2f);
        weatherData.setMeasurements
                (44.4f,44.4f,44.4f);
        weatherData.removeObserver(currentConditionsDisplay);
        weatherData.setMeasurements
                (33.3f,33.3f,33.3f);
    }
}
