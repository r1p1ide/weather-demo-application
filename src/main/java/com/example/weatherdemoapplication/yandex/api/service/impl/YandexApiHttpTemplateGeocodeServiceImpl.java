package com.example.weatherdemoapplication.yandex.api.service.impl;

import com.example.weatherdemoapplication.yandex.api.dto.GeocodeApiResponseDto;
import com.example.weatherdemoapplication.yandex.api.service.YandexApiHttpTemplateGeocodeService;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
@ConfigurationProperties("yandex.api.geocode")
@Setter
public class YandexApiHttpTemplateGeocodeServiceImpl implements YandexApiHttpTemplateGeocodeService {

    private String url;
    private String token;

    @Override
    public GeocodeApiResponseDto getGeocodeByAddress(String address) {

        log.info("Call getGeocodeByAddress({})", address);

        RestTemplate restTemplate = new RestTemplate();

        Map<String, String> params = new HashMap<>();
        params.put("apikey", token);
        params.put("geocode", address);
        params.put("format", "json");
        params.put("results", "1");

        GeocodeApiResponseDto response = restTemplate.getForObject(url, GeocodeApiResponseDto.class, params);

        log.info("Response getGeocodeByAddress({})={}", address,
                Objects.requireNonNull(response).getResponse().getGeoObjectCollection().featureMember.get(0).geoObject.point.pos);

        return response;
    }
}
