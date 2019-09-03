package com.training.bff.productcatalog.dto.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PriceDTO {

    private BigDecimal value;
    private String currency;
}
