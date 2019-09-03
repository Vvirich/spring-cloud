package com.training.bff.checkout.controller;

import com.training.bff.checkout.api.CartApi;
import com.training.bff.checkout.dto.CartDto;
import com.training.bff.checkout.request.CreateCartRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/cart")
public class CartController {

    @Autowired
    private CartApi cartApi;

    @PostMapping(value = "/createCart")
    public CartDto createCart(@RequestHeader("locale") String localeTag, @RequestBody @Validated CreateCartRequest createCartRequest) {
        return cartApi.createCart(localeTag, createCartRequest);
    }
}