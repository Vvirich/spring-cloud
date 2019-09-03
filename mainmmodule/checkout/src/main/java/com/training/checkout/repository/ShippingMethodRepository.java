package com.training.checkout.repository;

import io.sphere.sdk.shippingmethods.ShippingMethod;

public interface ShippingMethodRepository {

    ShippingMethod getShippingMethodById(String id);

    ShippingMethod getDefaultShippingMethod();
}
