package com.henripay.customerservice.service.impl;

import com.henripay.customerservice.dto.MerchantDTO;
import com.henripay.customerservice.mapper.MerchantMapper;
import com.henripay.domainservice.entity.AggregatorEntity;
import com.henripay.domainservice.entity.MerchantEntity;
import com.henripay.domainservice.entity.MetadataEntity;
import com.henripay.domainservice.repository.MerchantRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MerchantServiceTest {
    @Mock
    private MerchantRepository merchantRepository;
    private MerchantService underTest;
    @Mock
    private MerchantMapper merchantMapper;

    private MerchantDTO merchantDTO;
    private MerchantEntity merchantEntity;
    @BeforeEach
    void setUp() {
        underTest = new MerchantService(merchantRepository,merchantMapper);

    }

    @Test

    void canGetAllMerchants() {
        //when
        underTest.getAllMerchants();
        //then
        Mockito.verify(merchantRepository).findAll();
    }


    @Test
    void canSaveMerchant() {
        // Arrange
        MetadataEntity metadata = MetadataEntity.builder()
                .metadataId(2L)
                .build();

        AggregatorEntity aggregator = AggregatorEntity.builder()
                .aggregatorId(102L)
                .build();

        MerchantEntity savedMerchantEntity = MerchantEntity.builder()
                .merchantId(1002L)
                .merchantName("Saved Merchant")
                .merchantAddress("456 Saved Street")
                .merchantIban("SavedIBAN456")
                .merchantCode("S456")
                .metadata(metadata)
                .aggregator(aggregator)
                .build();

        MerchantDTO expectedMerchantDTO = new MerchantDTO();
        expectedMerchantDTO.setMerchantId("1002L");
        expectedMerchantDTO.setMerchantName("Saved Merchant");
        expectedMerchantDTO.setMerchantAddress("456 Saved Street");
        expectedMerchantDTO.setMerchantIban("SavedIBAN456");
        expectedMerchantDTO.setMerchantCode("54321");
        expectedMerchantDTO.setMetadata(2L);
        expectedMerchantDTO.setAggregator(102L);

        when(merchantMapper.toEntity(merchantDTO)).thenReturn(merchantEntity);
        when(merchantRepository.save(merchantEntity)).thenReturn(savedMerchantEntity);
        when(merchantMapper.toDto(savedMerchantEntity)).thenReturn(expectedMerchantDTO);

        // Act
        MerchantDTO result = underTest.saveMerchant(merchantDTO);

        // Assert
        assertThat(result).isEqualTo(expectedMerchantDTO);
        verify(merchantRepository, times(1)).save(merchantEntity);
        verify(merchantMapper, times(1)).toEntity(merchantDTO);
        verify(merchantMapper, times(1)).toDto(savedMerchantEntity);
    }


    @Test
    void deleteMerchant_shouldDeleteMerchantById() {
        // Arrange
        Long merchantId = 1001L;

        // Act
        underTest.deleteMerchant(merchantId);

        // Assert
        verify(merchantRepository, times(1)).deleteById(merchantId);
        verifyNoInteractions(merchantMapper);
    }

}