package com.training.productcatalog.mapper.impl;

import com.training.productcatalog.mapper.ProductTypeAbstractMapper;
import com.training.productcatalog.request.ProductTypeRequest;
import io.sphere.sdk.models.LocalizedString;
import io.sphere.sdk.products.attributes.AttributeConstraint;
import io.sphere.sdk.products.attributes.AttributeDefinition;
import io.sphere.sdk.products.attributes.AttributeDefinitionBuilder;
import io.sphere.sdk.products.attributes.AttributeDefinitionDraft;
import io.sphere.sdk.products.attributes.AttributeDefinitionDraftBuilder;
import io.sphere.sdk.products.attributes.ReferenceAttributeType;
import io.sphere.sdk.producttypes.ProductType;
import io.sphere.sdk.producttypes.commands.ProductTypeUpdateCommand;
import io.sphere.sdk.producttypes.commands.updateactions.AddAttributeDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ProductTypeUpdateWithReferenceAttributeMapper extends ProductTypeAbstractMapper<ProductType, ProductTypeUpdateCommand, ProductTypeRequest> {

    @Override
    public ProductTypeUpdateCommand map(ProductTypeRequest request) {
        final ProductType productType = getAdditionalObject();
        final AttributeConstraint constraint = AttributeConstraint.valueOf(request.getConstraint().toUpperCase());
        final String attributeName = request.getAttributeName();

        final AttributeDefinition attributeDefinition = AttributeDefinitionBuilder.of(attributeName,
                LocalizedString.of(request.getLocale(), attributeName),
                ReferenceAttributeType.of(request.getAttributeTypeReference())).build();

        final AttributeDefinitionDraft draft = AttributeDefinitionDraftBuilder.of(attributeDefinition)
                .searchable(request.isSearchable())
                .attributeConstraint(constraint).build();

        return ProductTypeUpdateCommand.of(productType, AddAttributeDefinition.of(draft));
    }
}
