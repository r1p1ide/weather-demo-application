package com.example.weatherdemoapplication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@Accessors
public class BaseWeatherResponse {

    private String address;
    private String unit;
    private int temperature;
}
