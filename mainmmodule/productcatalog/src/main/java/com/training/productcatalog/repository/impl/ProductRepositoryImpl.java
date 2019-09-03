package com.training.productcatalog.repository.impl;

import com.training.productcatalog.InitAttributeTypesMap;
import com.training.productcatalog.mapper.ProductTypeAbstractMapper;
import com.training.productcatalog.repository.ProductRepository;
import com.training.productcatalog.request.ProductTypeRequest;
import io.sphere.sdk.client.BlockingSphereClient;
import io.sphere.sdk.products.Product;
import io.sphere.sdk.products.queries.ProductByIdGet;
import io.sphere.sdk.products.queries.ProductByKeyGet;
import io.sphere.sdk.products.queries.ProductQuery;
import io.sphere.sdk.products.queries.ProductQueryModel;
import io.sphere.sdk.producttypes.ProductType;
import io.sphere.sdk.producttypes.commands.ProductTypeUpdateCommand;
import io.sphere.sdk.producttypes.queries.ProductTypeByIdGet;
import io.sphere.sdk.queries.Query;
import io.sphere.sdk.queries.QueryPredicate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Locale;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private final BlockingSphereClient client;
    private final InitAttributeTypesMap typesMap;

    public ProductRepositoryImpl(BlockingSphereClient client,
                                 InitAttributeTypesMap typesMap) {
        this.client = client;
        this.typesMap = typesMap;
    }

    @Override
    public Product getByKey(String key) {
        return client.executeBlocking(ProductByKeyGet.of(key));
    }

    @Override
    public Product getById(String id) {
        return client.executeBlocking(ProductByIdGet.of(id));
    }

    @Override
    public ProductType getProductTypeById(String id) {
        return client.executeBlocking(ProductTypeByIdGet.of(id));
    }

    @Override
    public List<Product> getByName(Locale locale, String name) {
        final QueryPredicate<Product> productQueryPredicate = ProductQueryModel.of().masterData().current().name().locale(locale).is(name);
        final Query<Product> productQuery = ProductQuery.of().withPredicates(productQueryPredicate);
        return client.executeBlocking(productQuery).getResults();
    }

    @Override
    public ProductType addAttributeToProductType(ProductTypeRequest productTypeRequest) {
        final ProductType productType = getProductTypeById(productTypeRequest.getProductTypeId());
        final ProductTypeAbstractMapper<ProductType, ProductTypeUpdateCommand, ProductTypeRequest> productTypeMapper =
                typesMap.getProductTypeAbstractMapperMap().get(productTypeRequest.getAttributeTypeName());
        productTypeMapper.setAdditionalObject(productType);
        return client.executeBlocking(productTypeMapper.map(productTypeRequest));
    }
}