package com.training.checkout.service.impl;

import com.training.checkout.repository.CartRepository;
import com.training.checkout.request.CreateCartRequest;
import com.training.checkout.service.CartService;
import io.sphere.sdk.carts.Cart;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;

    public CartServiceImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    public Cart createCart(CreateCartRequest createCartRequest) {
        return cartRepository.createCart(createCartRequest);
    }
}
