package com.example.weatherdemoapplication.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Accessors
public class ErrorDetails {

    private int code;
    private LocalDateTime timestamp;
    private boolean success;
    private String message;
}
