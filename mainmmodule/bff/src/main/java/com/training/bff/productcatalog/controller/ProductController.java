package com.training.bff.productcatalog.controller;

import com.training.bff.customer.api.CustomerApi;
import com.training.bff.productcatalog.api.ProductApi;
import com.training.bff.productcatalog.dto.product.ProductDTO;
import com.training.bff.productcatalog.dto.producttype.ProductTypeDTO;
import com.training.bff.productcatalog.request.ProductTypeRequest;
import com.training.bff.productcatalog.request.TestRequest;
import com.training.bff.productcatalog.response.ProductCatalogResponse;
import com.training.bff.productcatalog.response.TestResponse;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    private ProductApi productApi;
    @Autowired
    private CustomerApi customerApi;

    @GetMapping(value = "/getByKey")
    public ProductDTO getByKey(@RequestParam("key") String key) {
        return productApi.getByKey(key);
    }

    @GetMapping(value = "/getById")
    public ProductDTO getById(@RequestParam("id") String id) {
        return productApi.getById(id);
    }

    @GetMapping(value = "/searchByName/{name}")
    public ProductCatalogResponse<ProductDTO> findByName(@RequestHeader("locale") String localeTag, @PathVariable("name") String name) {
        return productApi.findByName(localeTag, name);
    }

    @PutMapping(value = "/addAttributeToProductType")
    public ProductTypeDTO addAttributeToProductType(@RequestHeader("locale") String localeTag, @RequestBody @Validated ProductTypeRequest productTypeRequest) {
        return productApi.addAttributeToProductType(localeTag, productTypeRequest);
    }

    @PostMapping(value = "/test")
    public String test(@RequestBody TestRequest testRequest){

        TestResponse response = productApi.test(testRequest);

        return customerApi.test(response);
    }
}
