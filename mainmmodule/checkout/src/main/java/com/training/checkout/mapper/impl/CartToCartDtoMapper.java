package com.training.checkout.mapper.impl;

import com.training.checkout.dto.CartDto;
import com.training.checkout.dto.LineItemDto;
import com.training.checkout.mapper.AbstractMapper;
import io.sphere.sdk.cartdiscounts.CartDiscount;
import io.sphere.sdk.carts.Cart;
import io.sphere.sdk.carts.LineItem;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import javax.money.MonetaryAmount;
import java.math.BigDecimal;
import java.util.List;
import java.util.Locale;

import static java.util.Objects.isNull;

@Component
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CartToCartDtoMapper extends AbstractMapper<Cart, CartDto, List<CartDiscount>> {

    private final AbstractMapper<Locale, List<LineItemDto>, List<LineItem>> convertLineItemToLineItemDto;

    public CartToCartDtoMapper(AbstractMapper<Locale, List<LineItemDto>, List<LineItem>> convertLineItemToLineItemDto) {
        this.convertLineItemToLineItemDto = convertLineItemToLineItemDto;
    }

    @Override
    public CartDto map(List<CartDiscount> cartDiscounts) {
        final Cart cart = getAdditionalObject();
        final CartDto cartDto = new CartDto();
        convertLineItemToLineItemDto.setAdditionalObject(cart.getLocale());
        cartDto.setLineItems(convertLineItemToLineItemDto.map(cart.getLineItems()));
        cartDto.setCartId(cart.getId());
        cartDto.setCustomerId(cart.getCustomerId());
        cartDto.setTotal(monetaryAmountToBigDecimal(cart.getTotalPrice()));
        cartDto.setShippingCost(monetaryAmountToBigDecimal(cart.getShippingInfo().getPrice()));
        return cartDto;
    }

    private BigDecimal monetaryAmountToBigDecimal(MonetaryAmount monetaryAmount) {
        if (isNull(monetaryAmount)) {
            return BigDecimal.ZERO;
        }
        return BigDecimal.valueOf(monetaryAmount.getNumber().doubleValue());
    }
}