package com.training.productcatalog.dto.producttype;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductTypeDTO {

    private String id;
    private String name;
    private String key;
    private String description;
    private List<AttributeDTO> attributes;
}
