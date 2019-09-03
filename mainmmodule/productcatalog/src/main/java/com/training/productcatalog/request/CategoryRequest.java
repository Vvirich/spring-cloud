package com.training.productcatalog.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import java.util.Locale;

@Data
public class CategoryRequest {

    @NotBlank
    private String name;
    @NotBlank
    private String description;
    @NotBlank
    private String slug;
    @NotBlank
    private String key;
    @NotBlank
    private String orderHint;
    @JsonProperty
    private Locale locale;
}
