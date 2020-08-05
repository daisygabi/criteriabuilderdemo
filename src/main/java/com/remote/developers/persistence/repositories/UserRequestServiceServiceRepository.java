package com.remote.developers.persistence.repositories;

import com.remote.developers.persistence.domain.UserRequestService;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@Repository
public class UserRequestServiceServiceRepository implements UserRequestServiceInterface {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(UserRequestService entity) {
        entityManager.persist(entity);
    }

    @Override
    public Optional<List<String>> findAllFeedbackThatExists() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<UserRequestService> criteriaQuery = criteriaBuilder.createQuery(UserRequestService.class);
        Root<UserRequestService> root = criteriaQuery.from(UserRequestService.class);

        CriteriaBuilder.Coalesce<UserRequestService> coalesceExpression = criteriaBuilder.coalesce();
        coalesceExpression.value(root.get("userFeedbackTitle"));
        coalesceExpression.value(root.get("userFeedbackDescription"));

        criteriaQuery.select(coalesceExpression);

        Query query = entityManager.createQuery(criteriaQuery);
        List<String> results = query.getResultList();
        Predicate<String> nullFilter = PojoPredicates.isValueNull();
        results.removeIf(nullFilter);

        return Optional.ofNullable(results);
    }
}
