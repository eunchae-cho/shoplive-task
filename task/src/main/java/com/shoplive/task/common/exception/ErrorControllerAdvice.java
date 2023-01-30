package com.shoplive.task.common.exception;

import com.shoplive.task.common.enums.ErrorCode;
import com.shoplive.task.common.exception.CustomException;
import com.shoplive.task.common.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class ErrorControllerAdvice {

    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    protected ResponseEntity<ApiResponse> handleException(Exception e) {
        ApiResponse apiResponse = ApiResponse.of(ErrorCode.BAD_REQUEST.getCode(), e.getMessage());
        return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = NoSuchElementException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    protected ResponseEntity<ApiResponse> handleNoSuchElementException(Exception e) {
        ApiResponse apiResponse = ApiResponse.of(ErrorCode.RESOURCE_NOT_FOUND.getCode(), e.getMessage());
        return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = CustomException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    protected ResponseEntity<ApiResponse> handleCustomException(CustomException e) {
        ApiResponse apiResponse = ApiResponse.of(ErrorCode.BAD_REQUEST.getCode(), e.getMessage());
        return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
    }
}
