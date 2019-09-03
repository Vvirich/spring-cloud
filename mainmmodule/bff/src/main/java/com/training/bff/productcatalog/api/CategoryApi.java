package com.training.bff.productcatalog.api;

import com.training.bff.productcatalog.request.CategoryRequest;
import io.sphere.sdk.categories.Category;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(value = "PRODUCTCATALOGSERVICE")
public interface CategoryApi {

    @PostMapping(value = "/category/createCategory")
    Category createCategory(@RequestHeader("locale") String localeTag, @RequestBody @Validated CategoryRequest categoryRequest);

    @GetMapping(value = "/category/getCategoryByKey/{key}")
    Category getCategoryByKey(@PathVariable("key") String key);

    @GetMapping(value = "/category/getCategoryById/{id}")
    Category getCategoryById(@PathVariable("id") String id);
}
