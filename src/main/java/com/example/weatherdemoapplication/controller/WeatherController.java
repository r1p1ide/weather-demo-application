package com.example.weatherdemoapplication.controller;

import com.example.weatherdemoapplication.dto.BaseWeatherResponse;
import com.example.weatherdemoapplication.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class WeatherController {

    private final WeatherService weatherService;

    @GetMapping(value = "/current")
    public BaseWeatherResponse getCurrentWeather(@RequestParam String address) {
        return weatherService.getCurrentWeather(address);
    }

    @GetMapping(value = "/forecast")
    public BaseWeatherResponse getWeatherAtTime(@RequestParam String address,
                                                @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
                                                        LocalDateTime timestamp) {
        return weatherService.getWeatherAtTime(address, timestamp);
    }
}
