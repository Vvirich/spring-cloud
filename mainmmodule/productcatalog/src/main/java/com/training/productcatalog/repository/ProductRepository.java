package com.training.productcatalog.repository;

import com.training.productcatalog.request.ProductTypeRequest;
import io.sphere.sdk.products.Product;
import io.sphere.sdk.producttypes.ProductType;

import java.util.List;
import java.util.Locale;

public interface ProductRepository {

    Product getByKey(String key);

    Product getById(String id);

    ProductType getProductTypeById(String id);

    List<Product> getByName(Locale locale, String name);

    ProductType addAttributeToProductType(ProductTypeRequest productTypeRequest);
}
