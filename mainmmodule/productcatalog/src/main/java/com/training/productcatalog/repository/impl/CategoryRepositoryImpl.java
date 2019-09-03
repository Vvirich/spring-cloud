package com.training.productcatalog.repository.impl;

import com.training.productcatalog.mapper.Mapper;
import com.training.productcatalog.repository.CategoryRepository;
import com.training.productcatalog.request.CategoryRequest;
import io.sphere.sdk.categories.Category;
import io.sphere.sdk.categories.commands.CategoryCreateCommand;
import io.sphere.sdk.categories.queries.CategoryByIdGet;
import io.sphere.sdk.categories.queries.CategoryByKeyGet;
import io.sphere.sdk.client.BlockingSphereClient;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryRepositoryImpl implements CategoryRepository {

    private final BlockingSphereClient client;
    private final Mapper<CategoryCreateCommand, CategoryRequest> categoryCreateCommandMapper;

    public CategoryRepositoryImpl(BlockingSphereClient client, Mapper<CategoryCreateCommand, CategoryRequest> categoryCreateCommandMapper) {
        this.client = client;
        this.categoryCreateCommandMapper = categoryCreateCommandMapper;
    }

    @Override
    public Category createCategory(CategoryRequest categoryRequest) {
        final CategoryCreateCommand categoryCreateCommand = categoryCreateCommandMapper.map(categoryRequest);
        return client.executeBlocking(categoryCreateCommand);
    }

    @Override
    public Category getCategoryByKey(String key) {
        return client.executeBlocking(CategoryByKeyGet.of(key));
    }

    @Override
    public Category getCategoryById(String id) {
        return client.executeBlocking(CategoryByIdGet.of(id));
    }
}