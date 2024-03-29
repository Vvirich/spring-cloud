package com.training.bff.productcatalog.dto.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SkuDTO {

    private String id;
    private String name;
    private List<String> images;
    private List<PriceDTO> prices;
}
