package com.training.bff.customer.controller;

import com.training.bff.customer.api.CustomerApi;
import com.training.bff.customer.request.CustomerRequest;
import com.training.bff.productcatalog.response.TestResponse;
import io.sphere.sdk.customers.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {

    @Autowired
    private CustomerApi customerApi;

    @PostMapping(value = "/create")
    public Customer createCustomer(@RequestBody @Validated CustomerRequest customerRequest) {
        return customerApi.createCustomer(customerRequest);
    }

    @GetMapping(value = "/getByKey")
    public Customer getByKey(@RequestParam("key") String key) {
        return customerApi.getByKey(key);
    }

//    @PostMapping(value = "/test")
//    public String test(){
//        return customerApi.test(createProfileRequest);
//    }
}
