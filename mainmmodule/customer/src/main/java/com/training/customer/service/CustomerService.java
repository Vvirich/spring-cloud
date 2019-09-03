package com.training.customer.service;

import com.training.customer.request.CustomerRequest;
import io.sphere.sdk.customers.Customer;

public interface CustomerService {

    Customer createCustomer(CustomerRequest request);

    Customer getByKey(String key);
}
