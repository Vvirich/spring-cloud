package com.training.productcatalog.service.impl;

import com.training.productcatalog.repository.CategoryRepository;
import com.training.productcatalog.request.CategoryRequest;
import com.training.productcatalog.service.CategoryService;
import io.sphere.sdk.categories.Category;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category createCategory(CategoryRequest categoryRequest) {
        return categoryRepository.createCategory(categoryRequest);
    }

    @Override
    public Category getCategoryByKey(String key) {
        return categoryRepository.getCategoryByKey(key);
    }

    @Override
    public Category getCategoryById(String id) {
        return categoryRepository.getCategoryById(id);
    }
}
