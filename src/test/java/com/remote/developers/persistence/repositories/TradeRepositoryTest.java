package com.remote.developers.persistence.repositories;

import com.remote.developers.persistence.domain.Trade;
import com.remote.developers.persistence.services.SearchCriteria;
import org.flywaydb.core.Flyway;
import org.flywaydb.test.annotation.FlywayTest;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

@FlywayTest
public class TradeRepositoryTest extends BasicRepositoryTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Autowired
    private TradeRepository repository;

    @Test
    public void findAllTradesWithNameSimilarTo_WithValidData_ShouldReturnListOfTrades() {
        Trade tradeToSave = buildTrade("Carpenter");
        repository.save(tradeToSave);

        Optional<List<Trade>> result = repository.findAllTradesWithNameSimilarTo(tradeToSave.getName());

        assertThat(result.get()).isNotEmpty();
    }

    @Test
    public void findAllTrades_WithValidData_ShouldReturnListOfTrades() {
        Trade firstTrade = buildTrade("Carpenter");
        Trade secondTrade = buildTrade("Optician");
        repository.save(firstTrade);
        repository.save(secondTrade);

        Optional<List<Trade>> result = repository.findAllTrades();
        System.out.println("result:" + result.get().size());

        assertThat(result.get()).isNotEmpty();
    }

    @Test
    public void findAllTradesWithNameEndingWith_WithValidData_ShouldReturnListOfTrades() {
        Trade trade = buildTrade("Optician");
        repository.save(trade);

        Optional<List<Trade>> result = repository.findAllTradesWithNameEndingWith("cian");

        assertThat(result.get()).isNotEmpty();
        assertEquals(result.get().size(), 2);
    }

    public Trade buildTrade(String name) {
        Trade trade = new Trade();
        trade.setName(name);
        trade.setCreatedAt(Calendar.getInstance().getTime());
        trade.setUpdatedAt(Calendar.getInstance().getTime());
        return trade;
    }
}
