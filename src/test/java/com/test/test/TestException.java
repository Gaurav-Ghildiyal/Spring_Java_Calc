package com.test.test;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TestException {
   @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<Map<String, Object>> handleArithmeticException(ArithmeticException ex) {
        Map<String, Object> errorDetails = new HashMap<>();
        errorDetails.put("timestamp", LocalDateTime.now());
        errorDetails.put("status", HttpStatus.BAD_REQUEST.value());
        errorDetails.put("error", HttpStatus.BAD_REQUEST.getReasonPhrase());
        errorDetails.put("message", ex.getMessage());
        errorDetails.put("path", "/api/calculator/divide");

        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }
}