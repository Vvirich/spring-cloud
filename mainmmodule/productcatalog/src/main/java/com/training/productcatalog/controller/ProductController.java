package com.training.productcatalog.controller;

import com.training.productcatalog.dto.product.ProductDTO;
import com.training.productcatalog.dto.producttype.ProductTypeDTO;
import com.training.productcatalog.request.ProductTypeRequest;
import com.training.productcatalog.request.TestRequest;
import com.training.productcatalog.response.ProductCatalogResponse;
import com.training.productcatalog.response.TestResponse;
import com.training.productcatalog.service.ProductService;
import io.sphere.sdk.producttypes.ProductType;
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

import java.util.Locale;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/getByKey")
    public ProductDTO getByKey(@RequestParam @NotBlank String key) {
        return productService.getByKey(key);
    }

    @GetMapping(value = "/getById")
    public ProductDTO getById(@RequestParam @NotBlank String id) {
        return productService.getById(id);
    }

    @GetMapping(value = "/searchByName/{name}")
    public ProductCatalogResponse<ProductDTO> findByName(@RequestHeader("locale") String localeTag, @PathVariable("name") @NotBlank String name) {
        final Locale locale = Locale.forLanguageTag(localeTag);
        return productService.getProductByName(locale, name);
    }

    @PutMapping(value = "/addAttributeToProductType")
    public ProductTypeDTO addAttributeToProductType(@RequestHeader("locale") String localeTag, @RequestBody @Validated ProductTypeRequest productTypeRequest) {
        productTypeRequest.setLocale(Locale.forLanguageTag(localeTag));
        return productService.addAttributeToProductType(productTypeRequest);
    }

    @PostMapping(value = "/test")
    public TestResponse test(@RequestBody TestRequest request){
        final TestResponse response = new TestResponse();
        response.setGg(request.getText() + " first text");
        response.setGgg(request.getTextt() + " second text");
        return response;
    }
}
