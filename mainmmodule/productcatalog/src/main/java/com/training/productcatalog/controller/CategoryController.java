package com.training.productcatalog.controller;

import com.training.productcatalog.request.CategoryRequest;
import com.training.productcatalog.service.CategoryService;
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

import java.util.Locale;

@RestController
@RequestMapping(value = "/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping(value = "/createCategory")
    public Category createCategory(@RequestHeader("locale") String localeTag, @RequestBody @Validated CategoryRequest categoryRequest) {
        categoryRequest.setLocale(Locale.forLanguageTag(localeTag));
        return categoryService.createCategory(categoryRequest);
    }

    @GetMapping(value = "/getCategoryById/{id}")
    public Category getCategoryById(@PathVariable("id") String id) {
        return categoryService.getCategoryById(id);
    }

    @GetMapping(value = "/getCategoryByKey/{key}")
    public Category getCategoryByKey(@PathVariable("key") String key){
        return categoryService.getCategoryByKey(key);
    }
}
