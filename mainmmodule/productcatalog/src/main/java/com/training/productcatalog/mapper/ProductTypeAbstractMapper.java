package com.training.productcatalog.mapper;

import lombok.Data;

@Data
public abstract class ProductTypeAbstractMapper<E, T, O> implements Mapper<T, O> {

    private E additionalObject;
}
