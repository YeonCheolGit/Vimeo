package com.example.vimeo.advice.exception;

public class WrongURL extends RuntimeException {

    public WrongURL() {
    }

    public WrongURL(String message) {
        super(message);
    }
}
