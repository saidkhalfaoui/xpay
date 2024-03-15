package com.henripay.customerservice.tests;

import com.henripay.domainservice.entity.AggregatorEntity;
import com.henripay.domainservice.entity.MerchantEntity;
import com.henripay.domainservice.entity.MetadataEntity;
import com.henripay.domainservice.repository.AggregatorRepository;
import com.henripay.domainservice.repository.MerchantRepository;
import com.henripay.domainservice.repository.MetadataRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestDataService {
    private final MetadataRepository metadataRepository;
    private final AggregatorRepository aggregatorRepository;
    private final MerchantRepository merchantRepository;

    public TestDataService(MetadataRepository metadataRepository, AggregatorRepository aggregatorRepository, MerchantRepository merchantRepository) {
        this.metadataRepository = metadataRepository;
        this.aggregatorRepository = aggregatorRepository;
        this.merchantRepository = merchantRepository;
    }

    public void saveData() {
        MetadataEntity metadataEntity = new MetadataEntity();
        metadataEntity.setTransactionFlows(new byte[]{0x01, 0x02, 0x03});
        metadataEntity.setMetadata(new byte[]{0x04, 0x05, 0x06});
        metadataRepository.save(metadataEntity);
        AggregatorEntity aggregatorEntity = new AggregatorEntity();
        aggregatorEntity.setAggregatorName("Sample Name");
        aggregatorEntity.setAggregatorAddress("Sample Address");
        aggregatorEntity.setAggregatorIban("Sample IBAN");
        aggregatorEntity.setMetadata(metadataEntity);
        aggregatorRepository.save(aggregatorEntity);
        metadataEntity.setTransactionFlows(new byte[]{0x0A, 0x0B, 0x0C}); // Sample transaction flows data
        metadataEntity.setMetadata(new byte[]{0x0D, 0x0E, 0x0F}); // Sample metadata
        metadataRepository.save(metadataEntity);
        MerchantEntity merchantEntity = new MerchantEntity();
        merchantEntity.setMerchantName("Sample Name");
        merchantEntity.setMerchantAddress("Sample Address");
        merchantEntity.setMerchantIban("Sample IBAN");
        merchantEntity.setMerchantCode("Sample Code");
        merchantEntity.setMetadata(metadataEntity);
        merchantEntity.setAggregator(aggregatorEntity);
        merchantRepository.save(merchantEntity);
    }

    public void printAllData() {
        System.out.println("Metadata:");
        List<MetadataEntity> metadataList = metadataRepository.findAll();
        for (MetadataEntity metadataEntity : metadataList) {
            System.out.println(metadataEntity);
        }

        System.out.println("\nAggregators:");
        List<AggregatorEntity> aggregatorList = aggregatorRepository.findAll();
        for (AggregatorEntity aggregatorEntity : aggregatorList) {
            System.out.println(aggregatorEntity);
        }

        System.out.println("\nMerchants:");
        List<MerchantEntity> merchantList = merchantRepository.findAll();
        for (MerchantEntity merchantEntity : merchantList) {
            System.out.println(merchantEntity);
        }
    }
}
