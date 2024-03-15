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
        // Generate sample byte arrays for demonstration purposes
        byte[] sampleTransactionFlows = {10, 20, 30, 40};
        byte[] sampleMetadataBytes = {50, 60, 70};

        MetadataEntity metadata = new MetadataEntity();
        metadata.setTransactionFlows(sampleTransactionFlows);
        metadata.setMetadata(sampleMetadataBytes);

        entityManager.persist(metadata);
        entityManager.flush();

        MetadataEntity found = metadataRepository.findById(metadata.getMetadataId()).orElse(null);

        assertThat(found).isNotNull();
        assertThat(found.getTransactionFlows()).isEqualTo(sampleTransactionFlows);
        assertThat(found.getMetadata()).isEqualTo(sampleMetadataBytes);

        // Test updating metadata
        byte[] updatedTransactionFlows = {80, 90};
        byte[] updatedMetadataBytes = {100, 110};
        metadata.setTransactionFlows(updatedTransactionFlows);
        metadata.setMetadata(updatedMetadataBytes);
        metadataRepository.save(metadata);

        assertThat(found.getTransactionFlows()).isEqualTo(updatedTransactionFlows);
        assertThat(found.getMetadata()).isEqualTo(updatedMetadataBytes);

        // Test deletion
        metadataRepository.delete(metadata);
        assertThat(metadataRepository.existsById(metadata.getMetadataId())).isFalse();
    }
}
