package com.training.customer.controller;

import com.training.customer.request.CreateProfileRequest;
import com.training.customer.request.CustomerRequest;
import com.training.customer.service.CustomerService;
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
    private CustomerService customerService;

    @PostMapping(value = "/create")
    public Customer createCustomer(@RequestBody @Validated CustomerRequest request) {
        return customerService.createCustomer(request);
    }

    @GetMapping(value = "/getByKey")
    public Customer getByKey(@RequestParam("key")String key){
        return customerService.getByKey(key);
    }

    @PostMapping(value = "/test")
    public String test(@RequestBody CreateProfileRequest createProfileRequest){
        return "first: " + createProfileRequest.getGg() + " second: " + createProfileRequest.getGgg();
    }
}
