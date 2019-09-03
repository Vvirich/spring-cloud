package com.training.bff.productcatalog.api;

import com.training.bff.productcatalog.dto.product.ProductDTO;
import com.training.bff.productcatalog.dto.producttype.ProductTypeDTO;
import com.training.bff.productcatalog.request.ProductTypeRequest;
import com.training.bff.productcatalog.request.TestRequest;
import com.training.bff.productcatalog.response.ProductCatalogResponse;
import com.training.bff.productcatalog.response.TestResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "PRODUCTCATALOG")
public interface ProductApi {

    @GetMapping(value = "/product/getByKey")
    ProductDTO getByKey(@RequestParam("key") String key);

    @GetMapping(value = "/product/getById")
    ProductDTO getById(@RequestParam("id") String id);

    @GetMapping(value = "/product/searchByName/{name}")
    ProductCatalogResponse<ProductDTO> findByName(@RequestHeader("locale") String localeTag, @PathVariable("name") String name);

    @PutMapping(value = "/product/addAttributeToProductType")
    ProductTypeDTO addAttributeToProductType(@RequestHeader("locale") String localeTag, @RequestBody @Validated ProductTypeRequest productTypeRequest);

    @PostMapping(value = "/product/test")
    TestResponse test(@RequestBody TestRequest testRequest);
}
