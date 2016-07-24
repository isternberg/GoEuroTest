package com.goeuro.data;

import java.util.List;

@FunctionalInterface
public interface APIConsumer<E,T> {

    List<E> consume(String ...args);

}
