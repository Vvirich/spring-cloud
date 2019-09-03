package com.training.customer.mapper;

public interface Mapper<O, I> {

    O map(I input);
}
