package com.training.productcatalog.service;

import com.training.productcatalog.request.CategoryRequest;
import io.sphere.sdk.categories.Category;

public interface CategoryService {

    Category createCategory(CategoryRequest categoryRequest);

    Category getCategoryByKey(String key);

    Category getCategoryById(String id);
}
