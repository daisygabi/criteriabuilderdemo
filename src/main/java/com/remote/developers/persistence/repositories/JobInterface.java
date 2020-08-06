package com.remote.developers.persistence.repositories;

import com.remote.developers.persistence.domain.Job;
import com.remote.developers.persistence.domain.PlatformUser;

import java.util.List;
import java.util.Optional;

public interface JobInterface {

    void save(Job entity);

    Optional<List<String>> findAllFeedbackThatExists();

    Optional<List<PlatformUser>> findJobsThatAreInProgress();
}
