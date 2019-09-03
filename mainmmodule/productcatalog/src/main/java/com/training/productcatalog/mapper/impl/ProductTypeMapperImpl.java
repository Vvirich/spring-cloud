package com.training.productcatalog.mapper.impl;

import com.training.productcatalog.dto.producttype.AttributeDTO;
import com.training.productcatalog.dto.producttype.ProductTypeDTO;
import com.training.productcatalog.mapper.Mapper;
import io.sphere.sdk.products.attributes.AttributeDefinition;
import io.sphere.sdk.producttypes.ProductType;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;
import java.util.stream.Collectors;

@Component
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ProductTypeMapperImpl implements Mapper<ProductTypeDTO, ProductType> {

    @Override
    public ProductTypeDTO map(ProductType productType) {
        final ProductTypeDTO productTypeDTO = new ProductTypeDTO();
        productTypeDTO.setId(productType.getId());
        productTypeDTO.setName(productType.getName());
        productTypeDTO.setKey(productType.getKey());
        productTypeDTO.setDescription(productType.getDescription());
        productTypeDTO.setAttributes(getAttributes(productType.getAttributes()));
        return productTypeDTO;
    }

    private List<AttributeDTO> getAttributes(List<AttributeDefinition> attributeDefinitions) {
        return attributeDefinitions.stream().map(attributeDefinition -> {
            final AttributeDTO attributeDTO = new AttributeDTO();
            attributeDTO.setName(attributeDefinition.getName());
            attributeDTO.setInputHint(String.valueOf(attributeDefinition.getInputHint()));
            attributeDTO.setAttributeConstraint(String.valueOf(attributeDefinition.getAttributeConstraint()));
            attributeDTO.setRequired(attributeDefinition.isRequired());
            attributeDTO.setSearchable(attributeDefinition.isSearchable());
            attributeDTO.setAttributeType(String.valueOf(attributeDefinition.getAttributeType()));
            return attributeDTO;
        }).collect(Collectors.toList());
    }
}
