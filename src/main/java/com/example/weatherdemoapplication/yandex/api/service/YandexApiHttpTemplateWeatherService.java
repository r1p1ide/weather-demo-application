package com.example.weatherdemoapplication.yandex.api.service;

import com.example.weatherdemoapplication.yandex.api.dto.WeatherApiResponseDto;

public interface YandexApiHttpTemplateWeatherService {

    WeatherApiResponseDto httpGetYandexApiWeather(String address);
}
