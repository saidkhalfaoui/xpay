package com.henripay.domainservice;

import com.henripay.domainservice.entity.MetadataEntity;
import com.henripay.domainservice.repository.MetadataRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class MetadataRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private MetadataRepository metadataRepository;

    @Test
    public void whenFindById_thenReturnMetadata() {
        // Given
        MetadataEntity metadata = new MetadataEntity();
        metadata.setTransactionFlows(new byte[]{1, 2, 3});
        metadata.setMetadata(new byte[]{4, 5, 6});

        entityManager.persist(metadata);
        entityManager.flush();

        // When
        MetadataEntity found = metadataRepository.findById(metadata.getMetadataId()).orElse(null);

        // Then
        assertThat(found).isNotNull();
        assertThat(found.getTransactionFlows()).isEqualTo(metadata.getTransactionFlows());
    }
}
