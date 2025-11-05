package com.example.portfolio.service.common.exception;

import org.springframework.http.HttpStatus;

public class NotFoundException extends BaseException {
    public NotFoundException(String message, int statusCode) {
        super(message, HttpStatus.NOT_FOUND.value());
    }
}
