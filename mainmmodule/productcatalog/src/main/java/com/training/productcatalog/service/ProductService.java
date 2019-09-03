package com.training.productcatalog.service;

import com.training.productcatalog.dto.product.ProductDTO;
import com.training.productcatalog.dto.producttype.ProductTypeDTO;
import com.training.productcatalog.request.ProductTypeRequest;
import com.training.productcatalog.response.ProductCatalogResponse;
import io.sphere.sdk.producttypes.ProductType;

import java.util.Locale;

public interface ProductService {

    ProductDTO getByKey(String key);

    ProductDTO getById(String id);

    ProductCatalogResponse<ProductDTO> getProductByName(Locale locale, String name);

    ProductTypeDTO addAttributeToProductType(ProductTypeRequest request);
}
