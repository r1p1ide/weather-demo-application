package com.example.weatherdemoapplication.service.impl;

import com.example.weatherdemoapplication.yandex.api.dto.WeatherApiResponseDto;
import com.example.weatherdemoapplication.yandex.api.service.YandexApiHttpTemplateWeatherService;
import com.example.weatherdemoapplication.dto.BaseWeatherResponse;
import com.example.weatherdemoapplication.service.WeatherService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class WeatherServiceImpl implements WeatherService {

    private final YandexApiHttpTemplateWeatherService yandexApiHttpTemplateWeatherService;

    @Override
    public BaseWeatherResponse getCurrentWeather(String address) {

        log.info("Call getCurrentWeather({})", address);

        WeatherApiResponseDto response = yandexApiHttpTemplateWeatherService.httpGetYandexApiWeather(address);

        log.info("Response getCurrentWeather({})={}", address, response.getFact().getTemp());

        return new BaseWeatherResponse(address, "celsius", response.getFact().getTemp());
    }

    @Override
    public BaseWeatherResponse getWeatherAtTime(String address, LocalDateTime timestamp) {

        log.info("Call getWeatherAtTime({}, {})", address, timestamp);

        WeatherApiResponseDto response = yandexApiHttpTemplateWeatherService.httpGetYandexApiWeather(address);

        String requestDate = timestamp.toString().substring(0, timestamp.toString().indexOf("T"));
        int requestHour = timestamp.getHour();
        for (WeatherApiResponseDto.Forecast forecast : response.getForecasts()) {
            if (forecast.getDate().equals(requestDate)) {
                log.info("Response getWeatherAtTime({}, {})={}",
                        address, timestamp, forecast.getHours().get(requestHour).getTemp());
                return new BaseWeatherResponse(address, "celsius", forecast.getHours().get(requestHour).getTemp());
            }
        }
        return null;
    }
}
