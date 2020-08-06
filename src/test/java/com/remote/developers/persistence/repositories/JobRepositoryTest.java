package com.remote.developers.persistence.repositories;

import com.remote.developers.persistence.domain.PlatformUser;
import org.flywaydb.test.annotation.FlywayTest;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@FlywayTest
public class JobRepositoryTest extends BasicRepositoryTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Autowired
    private JobRepository repository;

    // Use coalesce
    @Test
    public void findAllFeedback_WithValidData_ShouldReturnOnlyNonNullValues() {
        Optional<List<String>> result = repository.findAllFeedbackThatExists();

        assertThat(result.get()).isNotEmpty();
        assertThat(result.get().size()).isEqualTo(3);
    }

    @Test
    public void findJobsThatAreInProgress_WithValidData_ShouldReturn() {
        Optional<List<PlatformUser>> result = repository.findJobsThatAreInProgress();

        assertThat(result.get()).isNotEmpty();
    }
}
