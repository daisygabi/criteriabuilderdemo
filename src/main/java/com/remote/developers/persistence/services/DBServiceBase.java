package com.remote.developers.persistence.services;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class DBServiceBase<T> {
    @Autowired
    protected EntityManager entityManager;

    private CriteriaBuilder criteriaBuilder;
    private Class<T> classReference;

    protected CriteriaBuilder getCriteriaBuilder() {
        if (criteriaBuilder == null) {
            criteriaBuilder = entityManager.getCriteriaBuilder();
        }
        return criteriaBuilder;
    }

    protected DBServiceBase(Class<T> classReference) {
        this.classReference = classReference;
    }

    protected CriteriaQuery<T> getSelectQuery(QueryRefiner<T> queryRefiner) {
        CriteriaQuery<T> query = getCriteriaBuilder().createQuery(classReference);
        Root<T> root = query.from(classReference);
        query.select(root);
        refineQuery(query, root, queryRefiner);
        return query;
    }

    protected static <T> void refineQuery(CriteriaQuery<T> query, Root<T> root, QueryRefiner<T> refiner) {
        if (refiner != null) {
            refiner.accept(query, root);
        }
    }
}