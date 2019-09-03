package com.training.bff.checkout.api;

import com.training.bff.checkout.dto.CartDto;
import com.training.bff.checkout.request.CreateCartRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(value = "CHECKOUTSERVICE")
public interface CartApi {

    @PostMapping(value = "/cart/createCart")
    CartDto createCart(@RequestHeader("locale") String localeTag, @RequestBody @Validated CreateCartRequest createCartRequest);
}
