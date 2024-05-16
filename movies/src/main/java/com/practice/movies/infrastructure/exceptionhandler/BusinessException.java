package com.practice.movies.infrastructure.exceptionhandler;

public class BusinessException extends RuntimeException{
    public BusinessException(String message){
        super(message);
    }
}
