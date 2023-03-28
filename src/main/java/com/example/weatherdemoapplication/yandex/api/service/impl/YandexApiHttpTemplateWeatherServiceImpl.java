package com.example.weatherdemoapplication.yandex.api.service.impl;

import com.example.weatherdemoapplication.yandex.api.dto.WeatherApiResponseDto;
import com.example.weatherdemoapplication.yandex.api.service.YandexApiHttpTemplateGeocodeService;
import com.example.weatherdemoapplication.yandex.api.service.YandexApiHttpTemplateWeatherService;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
@ConfigurationProperties("yandex.api.weather")
@Slf4j
@Setter
public class YandexApiHttpTemplateWeatherServiceImpl implements YandexApiHttpTemplateWeatherService {

    private final YandexApiHttpTemplateGeocodeService yandexApiHttpTemplateGeocodeService;
    private String url;
    private String token;

    @Override
    public WeatherApiResponseDto httpGetYandexApiWeather(String address) {

        log.info("Call httpGetYandexApiWeather({})", address);

        String coordinates = yandexApiHttpTemplateGeocodeService.getGeocodeByAddress(address)
                .getResponse()
                .getGeoObjectCollection()
                .getFeatureMember()
                .get(0)
                .getGeoObject()
                .getPoint().getPos();

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Yandex-API-Key", token);

        String urlTemplate = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("lat", "{lat}")
                .queryParam("lon", "{lon}")
                .encode()
                .toUriString();

        Map<String, String> params = new HashMap<>();
        params.put("lon", coordinates.substring(0, coordinates.indexOf(" ")));
        params.put("lat", coordinates.substring(coordinates.indexOf(" ") + 1));

        ResponseEntity<WeatherApiResponseDto> response = restTemplate.exchange(
                urlTemplate,
                HttpMethod.GET,
                new HttpEntity<>(headers), WeatherApiResponseDto.class,
                params
        );

        log.info("Success httpGetYandexApiWeather({})", address);

        return response.getBody();
    }
}
