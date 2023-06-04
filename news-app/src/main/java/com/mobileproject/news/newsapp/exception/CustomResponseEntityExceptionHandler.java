package com.mobileproject.news.newsapp.exception;

import com.mobileproject.news.newsapp.exception.custom.NewsNotFoundException;
import com.mobileproject.news.newsapp.exception.response.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.Timestamp;

@ControllerAdvice
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NewsNotFoundException.class)
    public ResponseEntity<BaseResponse> handleNewsNotFoundException(NewsNotFoundException ex){
        String errorMessage = "news not found";
        String exceptionType = ex.getClass().getSimpleName();
        BaseResponse baseResponse = BaseResponse.builder()
                .status(HttpStatus.NOT_FOUND.value())
                .exceptionType(exceptionType)
                .message(errorMessage)
                .time(new Timestamp(System.currentTimeMillis()))
                .build();
        return new ResponseEntity<>(baseResponse, HttpStatus.NOT_FOUND);
    }

}
