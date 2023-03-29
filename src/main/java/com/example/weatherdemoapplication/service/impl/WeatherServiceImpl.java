package com.example.weatherdemoapplication.service.impl;

import com.example.weatherdemoapplication.auth.AuthProtos;
import com.example.weatherdemoapplication.auth.AuthServiceGrpc;
import com.example.weatherdemoapplication.exception.UnauthorizedException;
import com.example.weatherdemoapplication.service.AuthService;
import com.example.weatherdemoapplication.yandex.api.dto.WeatherApiResponseDto;
import com.example.weatherdemoapplication.yandex.api.service.YandexApiHttpTemplateWeatherService;
import com.example.weatherdemoapplication.dto.BaseWeatherResponse;
import com.example.weatherdemoapplication.service.WeatherService;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.netty.GrpcSslContexts;
import io.grpc.netty.NettyChannelBuilder;
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.net.ssl.SSLException;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class WeatherServiceImpl implements WeatherService {

    private final YandexApiHttpTemplateWeatherService yandexApiHttpTemplateWeatherService;
    private final AuthService authService;

    @Override
    public BaseWeatherResponse getCurrentWeather(String address, String username) {

        log.info("Call getCurrentWeather({}) by {}", address, username);

        authService.checkAccess(username);

        WeatherApiResponseDto response = yandexApiHttpTemplateWeatherService.httpGetYandexApiWeather(address);

        log.info("Response getCurrentWeather({})={}", address, response.getFact().getTemp());

        return new BaseWeatherResponse(address, "celsius", response.getFact().getTemp());
    }

    @Override
    public BaseWeatherResponse getWeatherAtTime(String address, LocalDateTime timestamp, String username) {

        log.info("Call getWeatherAtTime({}, {}) by {}", address, timestamp, username);

        authService.checkAccess(username);

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
