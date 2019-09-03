package com.training.customer.repository.impl;

import com.training.customer.mapper.Mapper;
import com.training.customer.repository.CustomerRepository;
import com.training.customer.request.CustomerRequest;
import io.sphere.sdk.client.BlockingSphereClient;
import io.sphere.sdk.customers.Customer;
import io.sphere.sdk.customers.commands.CustomerCreateCommand;
import io.sphere.sdk.customers.queries.CustomerByKeyGet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

    @Autowired
    private BlockingSphereClient client;

    private final Mapper<CustomerCreateCommand, CustomerRequest> customerCreateMapper;

    public CustomerRepositoryImpl(Mapper<CustomerCreateCommand, CustomerRequest> customerCreateMapper) {
        this.customerCreateMapper = customerCreateMapper;
    }

    @Override
    public Customer createCustomer(CustomerRequest customerRequest) {
        return client.executeBlocking(customerCreateMapper.map(customerRequest)).getCustomer();
    }

    @Override
    public Customer getByKey(String key) {
        return client.executeBlocking(CustomerByKeyGet.of(key));
    }
}
