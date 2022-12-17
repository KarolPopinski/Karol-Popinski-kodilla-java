package com.kodilla.testing.weather.stub;

import java.util.*;

public class WeatherForecast {

    private Temperatures temperatures;

    public WeatherForecast(Temperatures temperatures) {
        this.temperatures = temperatures;
    }

    public Map<String, Double> calculateForecast() {
        Map<String, Double> resultMap = new HashMap<>();

        for (Map.Entry<String, Double> temperature : temperatures.getTemperatures().entrySet()) {

            resultMap.put(temperature.getKey(), temperature.getValue() + 1.0);
        }
        return resultMap;
    }
    public double calculateAverage() {
        Map<String, Double> averageMap = new HashMap<>();
        double sum = 0;

        for (Map.Entry<String, Double> temperature : temperatures.getTemperatures().entrySet()) {
            sum += temperature.getValue();
        }
        double average = sum / temperatures.getTemperatures().size();
        return average;
    }
    public double calculateMedian() {
        List<Double> tempList = new ArrayList<>(temperatures.getTemperatures().values());

        Collections.sort(tempList);
        int middle = tempList.size() / 2;

        if (tempList.size() % 2 == 0) {
            Double firstHalf = tempList.get(middle);
            Double secondHalf = tempList.get(middle + 1);
            return (firstHalf + secondHalf) / 2;
        } else {
            Double median = tempList.get(middle);
            return median + 0.5;
        }
    }
}

