package com.training.productcatalog.service.impl;

import com.training.productcatalog.dto.product.ProductDTO;
import com.training.productcatalog.dto.producttype.ProductTypeDTO;
import com.training.productcatalog.mapper.impl.ProductMapperImpl;
import com.training.productcatalog.mapper.impl.ProductTypeMapperImpl;
import com.training.productcatalog.repository.ProductRepository;
import com.training.productcatalog.request.ProductTypeRequest;
import com.training.productcatalog.response.ProductCatalogResponse;
import com.training.productcatalog.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapperImpl productMapper;
    private final ProductTypeMapperImpl productTypeMapper;

    public ProductServiceImpl(ProductRepository productRepository, ProductMapperImpl productMapper, ProductTypeMapperImpl productTypeMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
        this.productTypeMapper = productTypeMapper;
    }

    @Override
    public ProductDTO getByKey(String key) {
        return productMapper.convert(productRepository.getByKey(key));
    }

    @Override
    public ProductDTO getById(String id) {
        return productMapper.convert(productRepository.getById(id));
    }

    @Override
    public ProductCatalogResponse<ProductDTO> getProductByName(Locale locale, String name) {
        return new ProductCatalogResponse<>(productRepository.getByName(locale, name).stream().map(productMapper::convert).collect(Collectors.toList()));
    }

    @Override
    public ProductTypeDTO addAttributeToProductType(ProductTypeRequest request) {
        return productTypeMapper.map(productRepository.addAttributeToProductType(request));
    }
}
