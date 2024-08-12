package com.springboot.EmployeeCRM.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<?> handleGlobalException(Exception exception, WebRequest webRequest){
        ApiErrorResponse apiErrorResponse=new ApiErrorResponse();
        apiErrorResponse.setSuccess(false);
        apiErrorResponse.setError(exception.getMessage());
        return new ResponseEntity<>(apiErrorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {ApiRequestException.class})
    public ResponseEntity<Object> handleApiRequestException(ApiRequestException e){
        ApiErrorResponse apiErrorResponse=new ApiErrorResponse();
        apiErrorResponse.setSuccess(false);
        apiErrorResponse.setError(e.getMessage());
        return new ResponseEntity<>(apiErrorResponse,HttpStatus.BAD_REQUEST);
    }
}
