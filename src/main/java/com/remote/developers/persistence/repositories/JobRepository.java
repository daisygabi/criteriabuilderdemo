package com.remote.developers.persistence.repositories;

import com.remote.developers.persistence.domain.Job;
import com.remote.developers.persistence.domain.PlatformUser;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@Repository
public class JobRepository implements JobInterface {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Job entity) {
        entityManager.persist(entity);
    }

    @Override
    public Optional<List<String>> findAllFeedbackThatExists() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Job> criteriaQuery = criteriaBuilder.createQuery(Job.class);
        Root<Job> root = criteriaQuery.from(Job.class);

        CriteriaBuilder.Coalesce<Job> coalesceExpression = criteriaBuilder.coalesce();
        coalesceExpression.value(root.get("userFeedbackTitle"));
        coalesceExpression.value(root.get("userFeedbackDescription"));

        criteriaQuery.select(coalesceExpression);

        Query query = entityManager.createQuery(criteriaQuery);
        List<String> results = query.getResultList();
        Predicate<String> nullFilter = PojoPredicates.isValueNull();
        results.removeIf(nullFilter);

        return Optional.ofNullable(results);
    }

    @Override
    public Optional<List<PlatformUser>> findUsersThatHaveJobsInProgress() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        CriteriaQuery<PlatformUser> userCriteriaQuery = criteriaBuilder.createQuery(PlatformUser.class);
        Root<PlatformUser> userRoot = userCriteriaQuery.from(PlatformUser.class);

        // Select user and job by user id
        Subquery<Job> jobSubQuery = userCriteriaQuery.subquery(Job.class);
        Root<Job> jobRoot = jobSubQuery.from(Job.class);
        jobSubQuery.select(jobRoot).where(criteriaBuilder.equal(jobRoot.get("userId"), userRoot.get("id")));
        userCriteriaQuery.select(userRoot).where(criteriaBuilder.exists(jobSubQuery));

        TypedQuery<PlatformUser> typedQuery = entityManager.createQuery(userCriteriaQuery);
        List<PlatformUser> resultList = typedQuery.getResultList();

        return Optional.of(resultList);
    }
}
