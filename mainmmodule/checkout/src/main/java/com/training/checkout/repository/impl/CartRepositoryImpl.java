package com.training.checkout.repository.impl;

import com.training.checkout.mapper.impl.CreateCartMapper;
import com.training.checkout.repository.CartRepository;
import com.training.checkout.repository.ShippingMethodRepository;
import com.training.checkout.request.CreateCartRequest;
import io.sphere.sdk.carts.Cart;
import io.sphere.sdk.client.BlockingSphereClient;
import io.sphere.sdk.shippingmethods.ShippingMethod;
import org.springframework.stereotype.Repository;

@Repository
public class CartRepositoryImpl implements CartRepository {

    private final BlockingSphereClient client;
    private final CreateCartMapper createCartMapper;
    private final ShippingMethodRepository shippingMethodRepository;

    public CartRepositoryImpl(BlockingSphereClient client, CreateCartMapper createCartMapper, ShippingMethodRepository shippingMethodRepository) {
        this.client = client;
        this.createCartMapper = createCartMapper;
        this.shippingMethodRepository = shippingMethodRepository;
    }

    @Override
    public Cart createCart(CreateCartRequest createCartRequest) {
        final ShippingMethod shippingMethod = shippingMethodRepository.getShippingMethodById(createCartRequest.getShippingMethodId());
        createCartMapper.setAdditionalObject(shippingMethod);
        return client.executeBlocking(createCartMapper.map(createCartRequest));
    }
}
