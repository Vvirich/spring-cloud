package com.training.services;

public class CaptchaException extends RuntimeException {

    public CaptchaException() {
        super();
    }

    public CaptchaException(Throwable throwable) {
        super(throwable);
    }

    public CaptchaException(String exceptionMessage) {
        super(exceptionMessage);
    }
}
