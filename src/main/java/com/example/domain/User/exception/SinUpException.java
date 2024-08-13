package com.example.domain.User.exception;

public class SinUpException extends RuntimeException {
    private String message;
    public SinUpException() {}
    public SinUpException(String message) {this.message = message;}
    public String getMessage() {return message;}
}
