package com.henripay.dataaccessservice.unittests;

import com.henripay.dataaccessservice.repository.AggregatorRepository;
import com.henripay.domainservice.entity.AggregatorEntity;
import jakarta.persistence.EntityManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@TestPropertySource(properties = "spring.liquibase.enabled=false")
@RunWith(SpringRunner.class)
@DataJpaTest
@EnableJpaRepositories(basePackages = {"com.henripay.dataaccessservice.repository", "com.henripay.domainservice.entity"})
public class AggregatorRepositoryTest {
    @Autowired
    private EntityManager entityManager;

    @Autowired
    private AggregatorRepository aggregatorRepository;

    @Test
    public void whenFindById_thenReturnAggregator() {
        // Given
        AggregatorEntity aggregator = new AggregatorEntity();
        aggregator.setAggregatorName("Test Aggregator");
        aggregator.setAggregatorAddress("Test Address");
        aggregator.setAggregatorIban("Test IBAN");

        entityManager.persist(aggregator);
        entityManager.flush();

        // When
        AggregatorEntity found = aggregatorRepository.findById(aggregator.getAggregatorId()).orElse(null);

        // Then
        assertThat(found).isNotNull();
        assertThat(found.getAggregatorName()).isEqualTo(aggregator.getAggregatorName());
    }
}
