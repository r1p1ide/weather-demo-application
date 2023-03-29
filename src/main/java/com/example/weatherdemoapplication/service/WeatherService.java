package com.example.weatherdemoapplication.service;

import com.example.weatherdemoapplication.dto.BaseWeatherResponse;

import java.time.LocalDateTime;

public interface WeatherService {

    BaseWeatherResponse getCurrentWeather(String address, String username);

    BaseWeatherResponse getWeatherAtTime(String address, LocalDateTime timestamp, String username);
}
