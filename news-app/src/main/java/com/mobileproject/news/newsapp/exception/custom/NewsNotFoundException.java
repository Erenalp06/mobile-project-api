package com.mobileproject.news.newsapp.exception.custom;

public class NewsNotFoundException extends RuntimeException{

    public NewsNotFoundException() {
    }

    public NewsNotFoundException(String message) {
        super(message);
    }

    public NewsNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public NewsNotFoundException(Throwable cause) {
        super(cause);
    }
}
