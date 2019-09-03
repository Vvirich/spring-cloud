package com.training.productcatalog.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Locale;

@Data
public class ProductTypeRequest {

    @NotBlank
    private String attributeTypeName;
    @NotBlank
    private String productTypeId;
    @NotBlank
    private String attributeName;
    @NotNull
    private boolean searchable;
    @NotBlank
    private String constraint;
    @JsonProperty
    private List<String> attributeEnumValues;
    @JsonProperty
    private Locale locale;
    @JsonProperty
    private String attributeTypeReference;
}
