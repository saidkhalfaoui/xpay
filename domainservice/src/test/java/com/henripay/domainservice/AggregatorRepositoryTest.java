package com.henripay.domainservice;

import com.henripay.domainservice.entity.AggregatorEntity;
import com.henripay.domainservice.repository.AggregatorRepository;
import jakarta.persistence.EntityManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AggregatorRepositoryTest {
    @Autowired
    private EntityManager entityManager;

    @Autowired
    private AggregatorRepository aggregatorRepository;

    @Test
    public void whenFindById_thenReturnAggregator() {
        // Given
        AggregatorEntity aggregator = new AggregatorEntity();
        aggregator.setAggregatorName("Test Aggregator 5");
        aggregator.setAggregatorAddress("Test Address 5");
        aggregator.setAggregatorIban("Test IBAN 5");

        entityManager.persist(aggregator);
        entityManager.flush();

        // When
        AggregatorEntity found = aggregatorRepository.findById(aggregator.getAggregatorId()).orElse(null);

        // Then
        assertThat(found).isNotNull();
        assertThat(found.getAggregatorName()).isEqualTo(aggregator.getAggregatorName());
    }
}
