package com.example.weatherdemoapplication.yandex.api.service;

import com.example.weatherdemoapplication.yandex.api.dto.GeocodeApiResponseDto;

public interface YandexApiHttpTemplateGeocodeService {

    GeocodeApiResponseDto getGeocodeByAddress(String address);
}
