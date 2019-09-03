package com.training.bff.productcatalog.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductCatalogResponse<T> {

    private List<T> productCatalogList;
}
