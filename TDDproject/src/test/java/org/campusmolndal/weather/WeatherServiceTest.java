package org.campusmolndal.weather;

import org.campusmolndal.api.JSONGetter;
import org.campusmolndal.weather.dao.Coord;
import org.campusmolndal.weather.dao.Weather;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class WeatherServiceTest {
    private WeatherService sut;
    private final String sampleJson = "{ \"coord\": { \"lon\": 11.97, \"lat\": 57.71 }, \"weather\": [ { \"id\": 804, \"main\": \"Clouds\", \"description\": \"overcast clouds\", \"icon\": \"04d\" } ], \"base\": \"stations\", \"main\": { \"temp\": 20.59, \"feels_like\": 20.13, \"temp_min\": 18.89, \"temp_max\": 21.74, \"pressure\": 1013, \"humidity\": 67 }, \"visibility\": 10000, \"wind\": { \"speed\": 5.14, \"deg\": 210, \"gust\": 7.2 }, \"clouds\": { \"all\": 90 }, \"dt\": 1599478913, \"sys\": { \"type\": 1, \"id\": 1752, \"country\": \"SE\", \"sunrise\": 1599457990, \"sunset\": 1599510755 }, \"timezone\": 7200, \"id\": 2711537, \"name\": \"Gothenburg\", \"cod\": 200 }";
    @Mock
    private JSONGetter apiHandler;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        sut = new WeatherService(apiHandler);
    }

    @Test
    void getWeatherValidCity() {
        // Arrange
        when(apiHandler.getJson("Gothenburg")).thenReturn(sampleJson);
        // Act
        Weather weather = sut.getWeather("Gothenburg");
        // Assert
        assertEquals("Clouds", weather.main);
    }
    @Test
    void getCoordValidCity() {
        //Arrange
        when(apiHandler.getJson("Gothenburg")).thenReturn(sampleJson);
        //Act
        Coord coord = sut.getCoord("Gothenburg");
        //Assert
        assertEquals(11.97, coord.lon);
        assertEquals(57.71, coord.lat);
    }
    @Test
    void getWeatherInvalidCity() {
        // Arrange
        when(apiHandler.getJson("Narnia")).thenReturn(null);
        // Act & assert
        assertThrows(RuntimeException.class, () -> sut.getWeather("Narnia"));
    }
    @Test
    void getCoordInvalidCity() {
        //Arrange
        when(apiHandler.getJson("Narnia")).thenReturn(null);
        //Act & assert
        assertThrows(RuntimeException.class, () -> sut.getCoord("Narnia"));
    }
    @Test
    void getWeatherSpecialCharacters() {
         //Arrange
        when(apiHandler.getJson("Göteborg")).thenReturn(sampleJson);
        //Act
        Weather weather = sut.getWeather("Göteborg");
        //Assert
        assertEquals("Clouds", weather.main);
    }
    @Test
    void getCoordSpecialCharacters() {
        //Arrange
        when(apiHandler.getJson("Göteborg")).thenReturn(sampleJson);
        //Act
        Coord coord = sut.getCoord("Göteborg");
        //Assert
        assertEquals(11.97, coord.lon);
        assertEquals(57.71, coord.lat);
    }
    @Test
    void getWeatherEmptyString() {
        //Arrange
        when(apiHandler.getJson("")).thenReturn(null);
        //Act & assert
        assertThrows(RuntimeException.class, () -> sut.getWeather(""));
    }
    @Test
    void getCoordEmptyString() {
        //Arrange
        when(apiHandler.getJson("")).thenReturn(null);
        //Act & assert
        assertThrows(RuntimeException.class, () -> sut.getCoord(""));
    }
    @Test
    void getWeatherNull() {
        //Arrange
        when(apiHandler.getJson(null)).thenReturn(null);
        //Act & assert
        assertThrows(RuntimeException.class, () -> sut.getWeather(null));
    }
    @Test
    void getCoordNull() {
        //Arrange
        when(apiHandler.getJson(null)).thenReturn(null);
        //Act & assert
        assertThrows(RuntimeException.class, () -> sut.getCoord(null));
    }
    @Test
    void getWeatherTimeout() {
        //Arrange
        when(apiHandler.getJson("Gothenburg")).thenReturn(sampleJson);
        //Act & assert
        assertTimeoutPreemptively(Duration.ofSeconds(2), () -> sut.getWeather("Gothenburg"));
    }
}