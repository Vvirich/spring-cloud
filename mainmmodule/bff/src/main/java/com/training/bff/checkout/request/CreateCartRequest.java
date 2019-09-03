package com.training.bff.checkout.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.Locale;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCartRequest {

    @NotEmpty
    private String shippingAddress;
    @NotEmpty
    private String currencyCode;
    @JsonProperty
    private Locale locale;
    @JsonProperty
    private String shippingMethodId;
    @JsonProperty
    private String customerId;
}
