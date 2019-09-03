package com.training.services;

public class CaptchaValidate {

    public static void validateCaptcha(CaptchaResponseDto response) {
        if (!response.isSuccess()) {
            throw new CaptchaException();
        }
        //TODO define what will be return if response is success
    }
}
