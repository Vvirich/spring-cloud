package com.training.productcatalog.mapper.impl;

import com.training.productcatalog.dto.product.PriceDTO;
import com.training.productcatalog.dto.product.ProductDTO;
import com.training.productcatalog.dto.product.SkuDTO;
import com.training.productcatalog.mapper.ProductMapper;
import io.sphere.sdk.categories.Category;
import io.sphere.sdk.models.Reference;
import io.sphere.sdk.products.Image;
import io.sphere.sdk.products.Price;
import io.sphere.sdk.products.Product;
import io.sphere.sdk.products.ProductData;
import io.sphere.sdk.products.ProductProjection;
import io.sphere.sdk.products.ProductVariant;
import io.sphere.sdk.producttypes.ProductType;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import javax.money.MonetaryAmount;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ProductMapperImpl implements ProductMapper<Product, ProductDTO, ProductProjection> {

    @Override
    public ProductDTO convert(Product product) {
        final ProductDTO productDTO = new ProductDTO();
        final ProductData productData = product.getMasterData().getCurrent();
        final List<ProductVariant> allVariants = Objects.requireNonNull(productData).getAllVariants();
        final Set<Reference<Category>> categories = productData.getCategories();
        productDTO.setId(product.getId());
        productDTO.setDescription(productData.getDescription());
        productDTO.setName(productData.getName());
        productDTO.setSlug(productData.getSlug());
        productDTO.setTypeId(product.getProductType().getId());
        productDTO.setCategoriesId(getCategoriesId(categories));
        productDTO.setSkus(getSkus(allVariants));
        return productDTO;
    }

    @Override
    public ProductDTO map(ProductProjection request) {
        final ProductDTO productDTO = new ProductDTO();
        final List<ProductVariant> allVariants = Objects.requireNonNull(request).getAllVariants();
        final Set<Reference<Category>> categories = request.getCategories();
        productDTO.setId(request.getId());
        productDTO.setDescription(request.getDescription());
        productDTO.setName(request.getName());
        productDTO.setSlug(request.getSlug());
        productDTO.setTypeId(request.getProductType().getId());
        productDTO.setCategoriesId(getCategoriesId(categories));
        productDTO.setSkus(getSkus(allVariants));
        return productDTO;
    }

    private String getCategoriesId(Set<Reference<Category>> categories) {
        return Objects.isNull(categories) ? null : categories.stream()
                .map(Reference::getId)
                .collect(Collectors.joining(", ", "[", "]"));
    }

    private List<SkuDTO> getSkus(List<ProductVariant> allVariants) {
        return allVariants
                .stream()
                .map(variant -> {
                    SkuDTO sku = new SkuDTO();
                    sku.setId(String.valueOf(variant.getId()));
                    sku.setName(variant.getSku());
                    sku.setImages(getImagesUrl(variant));
                    sku.setPrices(getPriceInfo(variant));
                    return sku;
                })
                .collect(Collectors.toList());
    }

    private List<PriceDTO> getPriceInfo(ProductVariant variant) {
        List<PriceDTO> prices = new ArrayList<>();
        if (Objects.nonNull(variant.getPrice())) {
            final Price price = variant.getPrice();
            prices.add(getPriceDto(price));
        } else {
            prices = variant.getPrices()
                    .stream()
                    .map(this::getPriceDto)
                    .collect(Collectors.toList());
        }
        return prices;
    }

    private List<String> getImagesUrl(ProductVariant variant) {
        return variant.getImages()
                .stream()
                .map(Image::getUrl)
                .collect(Collectors.toList());
    }

    private PriceDTO getPriceDto(Price price) {
        final PriceDTO priceDto = new PriceDTO();
        final MonetaryAmount monetaryAmount = price.getValue();
        priceDto.setValue(BigDecimal.valueOf(monetaryAmount.getNumber().doubleValueExact()));
        priceDto.setCurrency(monetaryAmount.getCurrency().getCurrencyCode());
        return priceDto;
    }

    private void fget(ProductType productType){
        productType.getAttributes().stream().map(attributeDefinition -> {
            attributeDefinition.getAttributeConstraint();
            attributeDefinition.getAttributeType();
            attributeDefinition.getInputHint();
            attributeDefinition.getName();
            return attributeDefinition;
        }).collect(Collectors.toList());
    }
}
