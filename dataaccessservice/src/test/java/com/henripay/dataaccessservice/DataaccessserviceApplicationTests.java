package com.henripay.dataaccessservice;

import com.henripay.dataaccessservice.repository.AggregatorRepository;
import com.henripay.domainservice.entity.AggregatorEntity;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.TestPropertySource;

import static org.assertj.core.api.Assertions.assertThat;

@TestPropertySource(properties = "spring.liquibase.enabled=false")
@SpringBootTest
@EnableJpaRepositories(basePackages = "com.henripay.domainservice.entity", basePackageClasses = AggregatorEntity.class)
class DataaccessserviceApplicationTests {

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
