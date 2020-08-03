package com.remote.developers.persistence.services;

import com.remote.developers.exceptions.CustomException;
import com.remote.developers.persistence.domain.Trade;
import com.remote.developers.persistence.repositories.TradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class TradeService {

    @Autowired
    private TradeRepository tradeRepository;

    public TradeService() {}

    public Optional<Trade> findById(Long id) {
        return tradeRepository.findById(id);
    }

    public List<Trade> findByTextInput(String input) {
        return tradeRepository.findByTextInput(input);
    }

    public List<Trade> getAllRemoteDeveloperWithTheSameLastName(String name) {
        try {
            return tradeRepository.getAllRemoteDeveloperWithTheSameLastName(name);
        } catch (Exception e) {
            throw new CustomException("Error retrieving all found developers with the same first name.", HttpStatus.UNPROCESSABLE_ENTITY, e);
        }
    }

    public Trade save(Trade trade) {
        return tradeRepository.save(trade);
    }
}
