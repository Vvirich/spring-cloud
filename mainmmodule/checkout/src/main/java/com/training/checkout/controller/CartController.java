package com.training.checkout.controller;

import com.training.checkout.request.CreateCartRequest;
import com.training.checkout.service.CartService;
import io.sphere.sdk.carts.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
@RequestMapping(value = "/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping(value = "/createCart")
    public Cart createCart(@RequestHeader("locale") String localeTag,@RequestBody @Validated CreateCartRequest createCartRequest) {
        createCartRequest.setLocale(Locale.forLanguageTag(localeTag));
        return cartService.createCart(createCartRequest);
    }
}
