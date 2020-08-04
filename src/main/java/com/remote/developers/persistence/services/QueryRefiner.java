package com.remote.developers.persistence.services;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.function.BiConsumer;

public interface QueryRefiner<T> extends BiConsumer<CriteriaQuery<T>, Root<T>> {}
