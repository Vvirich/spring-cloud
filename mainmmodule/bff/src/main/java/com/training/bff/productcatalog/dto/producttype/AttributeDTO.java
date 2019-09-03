package com.training.bff.productcatalog.dto.producttype;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttributeDTO {

    private String attributeConstraint;
    private String inputHint;
    private String attributeType;
    private String name;
    private boolean searchable;
    private boolean required;
}
