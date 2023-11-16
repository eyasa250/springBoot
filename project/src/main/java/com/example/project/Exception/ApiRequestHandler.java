package com.example.project.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZonedDateTime;

//this classe will be served as exception handler (aka : multiple exceptions)
@ControllerAdvice
public class ApiRequestHandler {
    @ExceptionHandler(value = {ApiRequestException.class})
    public ResponseEntity<Object> handleApiRequestException(ApiRequestException e) {
        // 1. Create payload containing exception details
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        ApiException ApiException = new ApiException(
                e.getMessage(),
                e,
                badRequest,
                ZonedDateTime.now()
        );

        // 2. Return response entity
        return new ResponseEntity<Object>(ApiException, badRequest);
    }

}
