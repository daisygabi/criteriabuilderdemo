package com.remote.developers.persistence.repositories;

import java.util.function.Predicate;

public class PojoPredicates {

    public static Predicate<String> isValueNull() {
        return p -> p == null;
    }
}
