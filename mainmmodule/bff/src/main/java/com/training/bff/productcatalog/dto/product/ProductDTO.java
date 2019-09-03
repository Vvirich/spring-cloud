package com.training.bff.productcatalog.dto.product;

import io.sphere.sdk.models.LocalizedString;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    private String id;
    private LocalizedString name;
    private LocalizedString slug;
    private String categoriesId;
    private String typeId;
    private LocalizedString description;
    private List<SkuDTO> skus;
}
