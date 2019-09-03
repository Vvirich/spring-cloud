package com.training.checkout.service;

import com.training.checkout.request.CreateCartRequest;
import io.sphere.sdk.carts.Cart;

public interface CartService {

    Cart createCart(CreateCartRequest createCartRequest);
}
