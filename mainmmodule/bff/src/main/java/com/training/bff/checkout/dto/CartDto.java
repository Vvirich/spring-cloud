package com.training.bff.checkout.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartDto {

    private String cartId;
    private String customerId;
    private BigDecimal subtotal;
    private BigDecimal total;
    private BigDecimal tax;
    private BigDecimal shippingCost;
    private BigDecimal discounted;
    private List<LineItemDto> lineItems;
}
