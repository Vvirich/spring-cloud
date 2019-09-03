package com.training.productcatalog.mapper;

public interface Mapper<T, O> {

    T map(O request);
}
