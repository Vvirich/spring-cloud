package com.training.productcatalog.mapper;

public interface ProductMapper<E, T, O> extends Mapper<T, O> {

    T convert(E product);
}
