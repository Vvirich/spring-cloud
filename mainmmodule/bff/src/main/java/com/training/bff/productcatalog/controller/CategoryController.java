package com.training.bff.productcatalog.controller;

import com.training.bff.productcatalog.api.CategoryApi;
import com.training.bff.productcatalog.request.CategoryRequest;
import io.sphere.sdk.categories.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/category")
public class CategoryController {

    @Autowired
    private CategoryApi categoryApi;

    @PostMapping(value = "/createCategory")
    public Category createCategory(@RequestHeader("locale") String localeTag, @RequestBody @Validated CategoryRequest categoryRequest) {
        return categoryApi.createCategory(localeTag, categoryRequest);
    }

    @GetMapping(value = "/getCategoryByKey/{key}")
    public Category getCategoryByKey(@PathVariable("key") String key){
        return categoryApi.getCategoryByKey(key);
    }

    @GetMapping(value = "/getCategoryById/{id}")
    public Category getCategoryById(@PathVariable("id") String id){
        return categoryApi.getCategoryById(id);
    }
}
