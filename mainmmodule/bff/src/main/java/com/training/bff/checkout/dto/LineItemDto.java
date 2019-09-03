package com.training.bff.checkout.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LineItemDto {

    private String id;
    private BigDecimal price;
    private String name;
    private Long quantity;
}
