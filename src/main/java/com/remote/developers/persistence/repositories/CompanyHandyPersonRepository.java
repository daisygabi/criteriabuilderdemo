package com.remote.developers.persistence.repositories;

import com.remote.developers.persistence.domain.CompanyHandyPerson;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

@Repository
public class CompanyHandyPersonRepository implements CompanyHandyPersonRepositoryInterface {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(CompanyHandyPerson entity) {
        entityManager.persist(entity);
    }

    @Override
    public Optional<List<CompanyHandyPerson>> findCompanyHandyPeopleThatHaveOneOfTheGivenTradeId(Long[] tradeIds) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<CompanyHandyPerson> criteriaQuery = criteriaBuilder.createQuery(CompanyHandyPerson.class);
        Root<CompanyHandyPerson> root = criteriaQuery.from(CompanyHandyPerson.class);
        criteriaQuery.select(root)
                .where(root.get("tradeId")
                        .in(tradeIds));

        Query query = entityManager.createQuery(criteriaQuery);
        List<CompanyHandyPerson> results = query.getResultList();

        return Optional.of(results);
    }

    @Override
    public Optional<List<CompanyHandyPerson>> findAllHandyPersons() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<CompanyHandyPerson> criteriaQuery = criteriaBuilder.createQuery(CompanyHandyPerson.class);
        Root<CompanyHandyPerson> root = criteriaQuery.from(CompanyHandyPerson.class);
        criteriaQuery.select(root);

        Query query = entityManager.createQuery(criteriaQuery);
        List<CompanyHandyPerson> results = query.getResultList();

        return Optional.of(results);
    }

    @Override
    public Optional<List<CompanyHandyPerson>> findCompanyHandyPeopleThatAreSoftwareDevelopers() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<CompanyHandyPerson> criteriaQuery = criteriaBuilder.createQuery(CompanyHandyPerson.class);
        Root<CompanyHandyPerson> root = criteriaQuery.from(CompanyHandyPerson.class);
        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("tradeId"), 1L));

        Query query = entityManager.createQuery(criteriaQuery);
        List<CompanyHandyPerson> results = query.getResultList();

        return Optional.of(results);
    }
}
