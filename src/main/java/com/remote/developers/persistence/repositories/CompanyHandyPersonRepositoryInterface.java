package com.remote.developers.persistence.repositories;

import com.remote.developers.persistence.domain.CompanyHandyPerson;

import java.util.List;
import java.util.Optional;

public interface CompanyHandyPersonRepositoryInterface {

    void save(CompanyHandyPerson entity);

    Optional<List<CompanyHandyPerson>> findCompanyHandyPeopleThatHaveOneOfTheGivenTradeId(Long[] tradeIds);

    Optional<List<CompanyHandyPerson>> findAllHandyPersons();

    Optional<List<CompanyHandyPerson>> findCompanyHandyPeopleThatAreSoftwareDevelopers();
}
