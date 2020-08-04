package com.remote.developers.persistence.services;

import com.remote.developers.persistence.domain.Trade;
import com.remote.developers.persistence.repositories.TradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TradeService extends DBServiceBase<Trade> {

    @Autowired
    private TradeRepository tradeRepository;

    public TradeService() {
        super(Trade.class);
    }

}
