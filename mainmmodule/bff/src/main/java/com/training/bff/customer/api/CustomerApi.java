package com.training.bff.customer.api;

import com.training.bff.customer.request.CustomerRequest;
import com.training.bff.productcatalog.response.TestResponse;
import io.sphere.sdk.customers.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "CUSTOMERSERVICE")
public interface CustomerApi {

    @PostMapping(value = "/customer/create")
    Customer createCustomer(@RequestBody @Validated CustomerRequest request);

    @GetMapping(value = "/customer/getByKey")
    Customer getByKey(@RequestParam("key") String key);

    @PostMapping(value = "/customer/test")
    String test(@RequestBody TestResponse createProfileRequest);
}
