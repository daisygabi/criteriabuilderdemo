package com.remote.developers.persistence.repositories;

import com.remote.developers.persistence.domain.Trade;
import com.remote.developers.persistence.services.SearchCriteria;
import com.remote.developers.persistence.services.UserSearchQueryCriteriaConsumer;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

@Repository
public class TradeRepository implements TradeRepositoryInterface {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<List<Trade>> findAllTradesWithNameSimilarTo(String tradeName) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Trade> criteriaQuery = criteriaBuilder.createQuery(Trade.class);
        Root<Trade> root = criteriaQuery.from(Trade.class);
        criteriaQuery.select(root).where(criteriaBuilder.like(root.get("name"), "%" + tradeName + "%"));

        Query query = entityManager.createQuery(criteriaQuery);
        List<Trade> results = query.getResultList();

        return Optional.of(results);
    }

    @Override
    public Optional<List<Trade>> findAllTradesWithNameEndingWith(String tradeName) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Trade> criteriaQuery = criteriaBuilder.createQuery(Trade.class);
        Root<Trade> root = criteriaQuery.from(Trade.class);
        criteriaQuery.select(root).where(criteriaBuilder.like(root.get("name"), "%" + tradeName));

        Query query = entityManager.createQuery(criteriaQuery);
        List<Trade> results = query.getResultList();

        return Optional.of(results);
    }

    @Override
    public Optional<List<Trade>> findAllTrades() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Trade> criteriaQuery = criteriaBuilder.createQuery(Trade.class);
        Root<Trade> root = criteriaQuery.from(Trade.class);
        criteriaQuery.select(root);

        Query query = entityManager.createQuery(criteriaQuery);
        List<Trade> results = query.getResultList();

        return Optional.of(results);
    }

    @Override
    public void save(Trade entity) {
        entityManager.persist(entity);
    }
}
