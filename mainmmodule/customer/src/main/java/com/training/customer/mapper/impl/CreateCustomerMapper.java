package com.training.customer.mapper.impl;

import com.training.customer.mapper.Mapper;
import com.training.customer.request.CustomerRequest;
import io.sphere.sdk.customers.CustomerDraft;
import io.sphere.sdk.customers.CustomerDraftBuilder;
import io.sphere.sdk.customers.CustomerName;
import io.sphere.sdk.customers.commands.CustomerCreateCommand;
import io.sphere.sdk.models.LocalizedString;
import io.sphere.sdk.types.CustomFieldsDraft;
import io.sphere.sdk.types.CustomFieldsDraftBuilder;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.util.Locale;

@Component
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CreateCustomerMapper implements Mapper<CustomerCreateCommand, CustomerRequest> {

    @Override
    public CustomerCreateCommand map(CustomerRequest input) {
        final CustomerName name = CustomerName.ofFirstAndLastName(input.getFirstName(), input.getSecondName());
        final CustomFieldsDraft draft1 = CustomFieldsDraftBuilder.ofTypeId("f02de6d8-3ff8-45ac-9cf7-9165c2a27b99")
                .addObject("testName", LocalizedString.of(Locale.US, "testValue")).build();
        final CustomerDraft draft = CustomerDraftBuilder.of(name, input.getEmail(), input.getPassword()).custom(draft1).build();
        return CustomerCreateCommand.of(draft);
    }
}
