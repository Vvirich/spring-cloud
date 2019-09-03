package com.training.productcatalog.repository;

import com.training.productcatalog.request.CategoryRequest;
import io.sphere.sdk.categories.Category;

public interface CategoryRepository {

    Category createCategory(CategoryRequest categoryRequest);

    Category getCategoryByKey(String key);

    Category getCategoryById(String id);
}
