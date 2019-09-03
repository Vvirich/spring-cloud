package com.training.checkout.mapper.impl;

import com.training.checkout.dto.LineItemDto;
import com.training.checkout.mapper.AbstractMapper;
import io.sphere.sdk.carts.LineItem;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Component
public class LineItemToLineItemDtoMapper extends AbstractMapper<Locale, List<LineItemDto>, List<LineItem>> {


    @Override
    public List<LineItemDto> map(List<LineItem> lineItems) {
        return lineItems.stream().map(item -> {
            final LineItemDto lineItemDto = new LineItemDto();
            lineItemDto.setId(item.getId());
            lineItemDto.setName(item.getName().get(getAdditionalObject()));
            lineItemDto.setPrice(BigDecimal.valueOf(item.getPrice().getValue().getNumber().doubleValue()));
            lineItemDto.setQuantity(item.getQuantity());
            return lineItemDto;
        }).collect(Collectors.toList());
    }
}
