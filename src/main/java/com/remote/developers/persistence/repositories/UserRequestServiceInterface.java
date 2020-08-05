package com.remote.developers.persistence.repositories;

import com.remote.developers.persistence.domain.UserRequestService;

import java.util.List;
import java.util.Optional;

public interface UserRequestServiceInterface {

    void save(UserRequestService entity);

    Optional<List<String>> findAllFeedbackThatExists();
}
