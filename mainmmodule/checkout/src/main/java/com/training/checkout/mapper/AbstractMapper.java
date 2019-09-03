package com.training.checkout.mapper;

import lombok.Data;

@Data
public abstract class AbstractMapper<E, T, O> implements Mapper<T, O> {

    private E additionalObject;
}
