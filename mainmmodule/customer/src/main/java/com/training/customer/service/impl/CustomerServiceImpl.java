package com.training.customer.service.impl;

import com.training.customer.repository.CustomerRepository;
import com.training.customer.request.CustomerRequest;
import com.training.customer.service.CustomerService;
import io.sphere.sdk.customers.Customer;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer createCustomer(CustomerRequest request) {
        return customerRepository.createCustomer(request);
    }

    @Override
    public Customer getByKey(String key) {
        return customerRepository.getByKey(key);
    }
}
