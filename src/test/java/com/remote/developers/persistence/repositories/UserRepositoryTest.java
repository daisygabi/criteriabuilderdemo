package com.remote.developers.persistence.repositories;

import org.flywaydb.test.annotation.FlywayTest;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@FlywayTest
public class UserRepositoryTest extends BasicRepositoryTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Autowired
    private UserRequestServiceServiceRepository repository;

    @Test
    public void findAllFeedback_WithValidData_ShouldReturnList() {
        Optional<List<String>> result = repository.findAllFeedbackThatExists();

        assertThat(result.get()).isNotEmpty();
        assertThat(result.get().size()).isEqualTo(3);
    }
}
