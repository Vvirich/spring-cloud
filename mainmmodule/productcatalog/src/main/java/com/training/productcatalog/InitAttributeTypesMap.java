package com.training.productcatalog;

import com.training.productcatalog.mapper.ProductTypeAbstractMapper;
import com.training.productcatalog.mapper.impl.ProductTypeUpdateWithEnumAttributeMapper;
import com.training.productcatalog.mapper.impl.ProductTypeUpdateWithReferenceAttributeMapper;
import com.training.productcatalog.request.ProductTypeRequest;
import io.sphere.sdk.producttypes.ProductType;
import io.sphere.sdk.producttypes.commands.ProductTypeUpdateCommand;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
@PropertySource("classpath:/attributeTypeNames.yml")
public final class InitAttributeTypesMap {


    @Value("${enumType}")
    private String enumType;
    @Value("${referenceType}")
    private String referenceType;
    private Map<String, ProductTypeAbstractMapper<ProductType, ProductTypeUpdateCommand, ProductTypeRequest>> productTypeAbstractMapperMap = new HashMap<>();
    private final ProductTypeUpdateWithEnumAttributeMapper enumAttributeMapper;
    private final ProductTypeUpdateWithReferenceAttributeMapper referenceAttributeMapper;

    public InitAttributeTypesMap(ProductTypeUpdateWithEnumAttributeMapper enumAttributeMapper, ProductTypeUpdateWithReferenceAttributeMapper referenceAttributeMapper) {
        this.enumAttributeMapper = enumAttributeMapper;
        this.referenceAttributeMapper = referenceAttributeMapper;
    }

    @PostConstruct
    public void initProductTypeUpdateMappers() {
        productTypeAbstractMapperMap.put(enumType, enumAttributeMapper);
        productTypeAbstractMapperMap.put(referenceType, referenceAttributeMapper);
    }

    public Map<String, ProductTypeAbstractMapper<ProductType, ProductTypeUpdateCommand, ProductTypeRequest>> getProductTypeAbstractMapperMap() {
        return productTypeAbstractMapperMap;
    }
}