package com.remote.developers.persistence.services;

import com.remote.developers.persistence.domain.Trade;
import com.remote.developers.persistence.repositories.TradeRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.Date;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
public class TradeTradeTest {

    @TestConfiguration
    static class EventServiceConfiguration {

        @Bean
        public TradeService remoteDevelopersService() {
            return new TradeService();
        }
    }

    @Autowired
    private TradeService tradeService;

    @MockBean
    private TradeRepository repository;
    private Trade trade;

    @Before
    public void setUp() {
        trade = new Trade();
        trade.setCreatedAt(new Date());
        trade.setId(1L);
        trade.setName("Softare Development");

        Mockito.when(repository.findById(1L)).thenReturn(java.util.Optional.ofNullable(trade));
        Mockito.when(repository.findByTextInput("Softare Development")).thenReturn(Collections.singletonList(trade));
        Mockito.when(repository.save(trade)).thenReturn(trade);
    }

    @Test
    public void findById_WithValidData_ShouldReturnDeveloper() {
        Optional<Trade> foundDeveloper = tradeService.findById(1L);

        assertThat(foundDeveloper.get().getName()).isEqualTo(trade.getName());
    }

    @Test
    public void findById_WithInValidData_ShouldReturnNothing() {
        Optional<Trade> foundDeveloper = tradeService.findById(100L);

        assertThat(foundDeveloper).isEmpty();
    }

    @Test
    public void saveDeveloper_WithValidData_ShouldCreateNewDeveloperEntry() {
        Trade savedDeveloper = tradeService.save(trade);

        assertThat(savedDeveloper.getName()).isEqualTo(savedDeveloper.getName());
        assertThat(savedDeveloper.getId()).isEqualTo(savedDeveloper.getId());
    }

    @Test()
    public void saveDeveloper_WithInValidData_ShouldCreateNewDeveloperEntry() {
        Trade savedDeveloper = tradeService.save(null);

        assertThat(savedDeveloper).isNull();
    }
}