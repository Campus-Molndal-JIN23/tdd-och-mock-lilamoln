package org.campusmolndal.weather;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.campusmolndal.api.JSONGetter;
import org.campusmolndal.weather.dao.Coord;
import org.campusmolndal.weather.dao.Weather;
import org.campusmolndal.weather.dao.WeatherDAO;

public class WeatherService {
    private final JSONGetter apiHandler;
    public WeatherService(JSONGetter apiHandler) {
        this.apiHandler = apiHandler;
    }
    private WeatherDAO getWeatherDAO(String city) {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = apiHandler.getJson(city);
        if(json == null || json.isEmpty()) throw new RuntimeException("Error getting data from API");
        try {
            return objectMapper.readValue(json, WeatherDAO.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error getting data from API", e);
        }
    }
    public Weather getWeather(String city) {
        return getWeatherDAO(city).weather.get(0);
    }
    public Coord getCoord(String city) {
        return getWeatherDAO(city).coord;
    }
}