package com.example.weatherdemoapplication.exception.handler;

import com.example.weatherdemoapplication.exception.UnauthorizedException;
import com.example.weatherdemoapplication.util.ErrorDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.time.LocalDateTime;

@RestControllerAdvice
@Slf4j
public class WeatherControllerAdvice {

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErrorDetails> handleMethodArgumentTypeMismatchException() {
        log.error("Caught MethodArgumentTypeMismatchException");
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ErrorDetails(400, LocalDateTime.now(), false, "Неверный формат ввода."));
    }

    @ExceptionHandler(IndexOutOfBoundsException.class)
    public ResponseEntity<ErrorDetails> handleIndexOutOfBoundsException() {
        log.error("Caught IndexOutOfBoundsException");
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ErrorDetails(400, LocalDateTime.now(), false, "Указан неверный адрес."));
    }

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<ErrorDetails> handleUnauthorizedException() {
        log.error("Caught UnauthorizedException");
        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body(new ErrorDetails(400, LocalDateTime.now(), false, "Доступ запрещен."));
    }
}
