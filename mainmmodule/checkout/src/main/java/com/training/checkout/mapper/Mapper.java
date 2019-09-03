package com.training.checkout.mapper;

public interface Mapper<T, O> {

    T map(O request);
}
