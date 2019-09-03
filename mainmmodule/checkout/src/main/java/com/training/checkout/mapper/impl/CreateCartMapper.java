package com.training.checkout.mapper.impl;

import com.neovisionaries.i18n.CountryCode;
import com.training.checkout.mapper.AbstractMapper;
import com.training.checkout.request.CreateCartRequest;
import com.training.checkout.unit.ValidateCountryCode;
import com.training.checkout.unit.ValidateCustomerId;
import io.sphere.sdk.carts.CartDraft;
import io.sphere.sdk.carts.TaxMode;
import io.sphere.sdk.carts.commands.CartCreateCommand;
import io.sphere.sdk.models.Address;
import io.sphere.sdk.shippingmethods.ShippingMethod;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import javax.money.Monetary;

@Component
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CreateCartMapper extends AbstractMapper<ShippingMethod, CartCreateCommand, CreateCartRequest> {

    private final ValidateCountryCode validateCountryCode;
    private final ValidateCustomerId validateCustomerId;

    public CreateCartMapper(ValidateCountryCode validateCountryCode, ValidateCustomerId validateCustomerId) {
        this.validateCountryCode = validateCountryCode;
        this.validateCustomerId = validateCustomerId;
    }

    @Override
    public CartCreateCommand map(CreateCartRequest request) {
        final CountryCode countryCode = validateCountryCode.validateCountryCode(request.getLocale().getCountry());
        final ShippingMethod shippingMethod = getAdditionalObject();
        final String anonymousId = validateCustomerId.generateAnonymousId();
        final CartDraft cartDraft = CartDraft.of(Monetary.getCurrency(request.getCurrencyCode()))
                .withCountry(countryCode)
                .withLocale(request.getLocale())
                .withShippingAddress(Address.of(countryCode).withAdditionalAddressInfo(request.getShippingAddress()))
                .withAnonymousId(anonymousId)
                .withShippingMethod(shippingMethod)
                .withTaxMode(TaxMode.PLATFORM);
        return CartCreateCommand.of(cartDraft);
    }
}
