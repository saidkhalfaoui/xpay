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
    public void test() {

        AggregatorEntity aggregator = new AggregatorEntity();
        aggregator.setAggregatorName("Test Aggregator 5");
        aggregator.setAggregatorAddress("Test Address 5");
        aggregator.setAggregatorIban("Test IBAN 5");

        entityManager.persist(aggregator);
        entityManager.flush();

        AggregatorEntity found = aggregatorRepository.findById(aggregator.getAggregatorId()).orElse(null);

        assertThat(found).isNotNull();
        assertThat(found.getAggregatorName()).isEqualTo(aggregator.getAggregatorName());

        aggregator.setAggregatorName("UpdatedName");
        aggregatorRepository.save(aggregator);

        assertThat(found.getAggregatorName()).isEqualTo(aggregator.getAggregatorName());

        assertThat(aggregatorRepository.findAll()).size().isEqualTo(1);

        aggregatorRepository.delete(aggregator);
        assertThat(aggregatorRepository.existsById(aggregator.getAggregatorId())).isFalse();
    }


}
