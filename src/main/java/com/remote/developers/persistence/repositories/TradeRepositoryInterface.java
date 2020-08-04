package com.remote.developers.persistence.repositories;

import com.remote.developers.persistence.domain.Trade;

import java.util.List;
import java.util.Optional;

public interface TradeRepositoryInterface {

    void save(Trade entity);

    Optional<List<Trade>> findAllTradesWithNameSimilarTo(String tradeName);

    Optional<List<Trade>> findAllTradesWithNameEndingWith(String tradeName);

    Optional<List<Trade>> findAllTrades();
}
