package com.training.checkout.repository.impl;

import com.training.checkout.repository.ShippingMethodRepository;
import io.sphere.sdk.client.BlockingSphereClient;
import io.sphere.sdk.shippingmethods.ShippingMethod;
import io.sphere.sdk.shippingmethods.queries.ShippingMethodByIdGet;
import org.springframework.stereotype.Repository;

@Repository
public class ShippingMethodRepositoryImpl implements ShippingMethodRepository {

    private final BlockingSphereClient client;

    public ShippingMethodRepositoryImpl(BlockingSphereClient client) {
        this.client = client;
    }

    @Override
    public ShippingMethod getShippingMethodById(String id) {
        return client.executeBlocking(ShippingMethodByIdGet.of(id));
    }

    @Override
    public ShippingMethod getDefaultShippingMethod() {
        return null;
    }
}
