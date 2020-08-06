package com.remote.developers.persistence.repositories;

import com.remote.developers.persistence.domain.CompanyHandyPerson;
import org.flywaydb.test.annotation.FlywayTest;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@FlywayTest
public class CompanyHandyPersonRepositoryTest extends BasicRepositoryTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Autowired
    private CompanyHandyPersonRepository repository;

    @Test
    void findCompanyHandyPeopleThatHaveOneOfTheGivenTradeId_WithValidData_ShouldReturnOnePerson() {
        CompanyHandyPerson firstCompanyHandyPerson = buildHandyPerson("Macey Doe", 1L, 3L);
        repository.save(firstCompanyHandyPerson);
        CompanyHandyPerson secondCompanyHandyPerson = buildHandyPerson("Someone Doe", 2L, 3L);
        repository.save(secondCompanyHandyPerson);

        Optional<List<CompanyHandyPerson>> result = repository.findCompanyHandyPeopleThatHaveOneOfTheGivenTradeId(new Long[]{firstCompanyHandyPerson.getTradeId()});
        assertThat(result.get()).isNotEmpty();
    }

    @Test
    void findAllHandyPersons_WithValidData_ShouldReturnListOfCompanyHandyPersons() {
        CompanyHandyPerson firstCompanyHandyPerson = buildHandyPerson("Eco Friendly", 1L, 2L);
        repository.save(firstCompanyHandyPerson);

        Optional<List<CompanyHandyPerson>> result = repository.findAllHandyPersons();
        assertThat(result.get()).isNotEmpty();
    }

    @Test
    void findCompanyHandyPeopleThatAreSoftwareDevelopers_WithValidData_ShouldReturnListOfTwoHandyPersons() {
        CompanyHandyPerson firstCompanyHandyPerson = buildHandyPerson("Eco Friendly", 1L, 2L);
        repository.save(firstCompanyHandyPerson);

        Optional<List<CompanyHandyPerson>> result = repository.findCompanyHandyPeopleThatAreSoftwareDevelopers();
        assertThat(result.get()).isNotEmpty();
        assertThat(result.get().size()).isEqualTo(2);
    }

    public CompanyHandyPerson buildHandyPerson(String name, Long tradeId, Long companyId) {
        CompanyHandyPerson companyHandyPerson = new CompanyHandyPerson();
        companyHandyPerson.setFullName(name);
        companyHandyPerson.setTradeId(tradeId);
        companyHandyPerson.setCompanyId(companyId);
        companyHandyPerson.setComment(null);
        companyHandyPerson.setCreatedAt(Calendar.getInstance().getTime());
        companyHandyPerson.setUpdatedAt(Calendar.getInstance().getTime());
        return companyHandyPerson;
    }
}
