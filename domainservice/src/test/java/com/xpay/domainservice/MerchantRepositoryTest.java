package com.xpay.domainservice;

import com.xpay.domainservice.entity.AggregatorEntity;
import com.xpay.domainservice.entity.MerchantEntity;
import com.xpay.domainservice.entity.MetadataEntity;
import com.xpay.domainservice.repository.MerchantRepository;
import jakarta.persistence.EntityManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class MerchantRepositoryTest {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private MerchantRepository merchantRepository;

    @Test
    public void testMerchantPersistence() {

        // Create a sample Merchant with necessary dependencies
        MetadataEntity sampleMetadata = createSampleMetadata();
        AggregatorEntity sampleAggregator = createSampleAggregator();
        MerchantEntity merchant = createSampleMerchant(sampleMetadata, sampleAggregator);

        entityManager.persist(merchant);
        entityManager.flush();

        MerchantEntity found = merchantRepository.findById(merchant.getMerchantId()).orElse(null);

        assertThat(found).isNotNull();
        assertThat(found.getMerchantName()).isEqualTo(merchant.getMerchantName());
        assertThat(found.getMetadata()).isEqualTo(sampleMetadata);
        assertThat(found.getAggregator()).isEqualTo(sampleAggregator);

        // Test updating a merchant
        merchant.setMerchantAddress("Updated Address");
        merchantRepository.save(merchant);

        assertThat(found.getMerchantAddress()).isEqualTo("Updated Address");

        // Test deletion
        merchantRepository.delete(merchant);
        assertThat(merchantRepository.existsById(merchant.getMerchantId())).isFalse();
    }

    // Helper methods to create sample entities as needed
    private MetadataEntity createSampleMetadata() {
        MetadataEntity metadata = new MetadataEntity();

        // Generate sample byte arrays for demonstration purposes
        byte[] sampleTransactionFlows = {10, 20, 30, 40}; // Replace with actual transaction flows data
        byte[] sampleMetadataBytes = {50, 60, 70}; // Replace with actual metadata bytes

        metadata.setTransactionFlows(sampleTransactionFlows);
        metadata.setMetadata(sampleMetadataBytes);
        entityManager.persist(metadata);
        entityManager.flush();
        return metadata;
    }


    private AggregatorEntity createSampleAggregator() {
        AggregatorEntity aggregator = new AggregatorEntity();
        aggregator.setAggregatorName("Test Aggregator Name");
        aggregator.setAggregatorAddress("Test Aggregator Address");
        aggregator.setAggregatorIban("Test Aggregator IBAN");

        // Set metadata for aggregator if required in your model
        MetadataEntity aggregatorMetadata = createSampleMetadata(); // Assuming AggregatorEntity also has metadata
        aggregator.setMetadata(aggregatorMetadata);
        entityManager.persist(aggregator);
        entityManager.flush();
        return aggregator;
    }

    private MerchantEntity createSampleMerchant(MetadataEntity metadata, AggregatorEntity aggregator) {
        MerchantEntity merchant = new MerchantEntity();
        merchant.setMerchantName("Test Merchant Name");
        merchant.setMerchantAddress("Test Merchant Address");
        merchant.setMerchantIban("Test Merchant IBAN");
        merchant.setMerchantCode("unique_merchant_code"); // Replace with actual generation mechanism
        merchant.setMetadata(metadata);
        merchant.setAggregator(aggregator);
        return merchant;
    }
}
