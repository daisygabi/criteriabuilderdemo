package com.remote.developers.persistence.repositories;

import com.remote.developers.persistence.domain.Trade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TradeRepository extends JpaRepository<Trade, Long> {

    @Query("SELECT dev FROM Trade dev where dev.firstName = ?1")
    List<Trade> getAllRemoteDeveloperWithTheSameLastName(String firstName);

    @Query("SELECT dev from Trade dev where lower(dev.firstName) LIKE %:input% or lower(dev.lastName) LIKE %:input%")
    List<Trade> findByTextInput(@Param("input") String input);
}
