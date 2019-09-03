package com.training.customer.repository;


import com.training.customer.request.CustomerRequest;
import io.sphere.sdk.customers.Customer;

public interface CustomerRepository {

    Customer createCustomer(CustomerRequest customerRequest);

    Customer getByKey(String key);
}
