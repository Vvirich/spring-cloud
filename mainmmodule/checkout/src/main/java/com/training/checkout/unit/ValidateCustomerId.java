package com.training.checkout.unit;

import io.sphere.sdk.carts.Cart;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:constants.yml")
public final class ValidateCustomerId {

    @Value("${anonymousIdBound}")
    private int bound;

    public String generateAnonymousId() {
        return RandomStringUtils.randomAlphabetic(bound);
    }

    public String validateCustomerId(Cart cart) {
        //FIXME now in this project we using only anonymousId but if it changed we have to add validation for cart
        // if customerId isNull return anonymous id if not return customerId
        return null;
    }
}
