package com.training.checkout.repository;

import com.training.checkout.request.CreateCartRequest;
import io.sphere.sdk.carts.Cart;

public interface CartRepository {

    Cart createCart(CreateCartRequest createCartRequest);
}
