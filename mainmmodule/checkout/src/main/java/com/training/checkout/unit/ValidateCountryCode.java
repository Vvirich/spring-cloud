package com.training.checkout.unit;

import com.neovisionaries.i18n.CountryCode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import static org.apache.commons.lang3.StringUtils.isNotEmpty;


@Component
@PropertySource("classpath:constants.yml")
public final class ValidateCountryCode {

    @Value("${defaultCountryCode}")
    private String defaultCountryCode;

    public CountryCode validateCountryCode(String country) {
        if (isNotEmpty(country)) {
            return CountryCode.valueOf(country);
        }
        return CountryCode.valueOf(defaultCountryCode);
    }
}
