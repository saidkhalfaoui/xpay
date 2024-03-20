package com.henripay.customerservice.service.impl;

import com.henripay.customerservice.dto.MerchantDTO;
import com.henripay.customerservice.mapper.MerchantMapper;
import com.henripay.domainservice.entity.MerchantEntity;
import com.henripay.domainservice.repository.MerchantRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;
import com.henripay.domainservice.exception.InvalidInput;
import org.mockito.InjectMocks;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class MerchantServiceTest {
    @Mock
    private MerchantRepository merchantRepository;

    @Mock
    private MerchantMapper mapper;

    @InjectMocks
    private MerchantService merchantService;

    @Test
    void saveMerchant() {
        MerchantDTO merchantDTO = new MerchantDTO();
        MerchantEntity merchantEntity = new MerchantEntity();
        when(mapper.toEntity(merchantDTO)).thenReturn(merchantEntity);
        when(merchantRepository.save(merchantEntity)).thenReturn(merchantEntity);
        when(mapper.toDto(merchantEntity)).thenReturn(merchantDTO);

        MerchantDTO result = merchantService.saveMerchant(merchantDTO);

        assertEquals(merchantDTO, result);
        verify(mapper, times(1)).toEntity(merchantDTO);
        verify(merchantRepository, times(1)).save(merchantEntity);
        verify(mapper, times(1)).toDto(merchantEntity);
    }

    @Test
    void getMerchantById() {
        Long id = 1L;
        MerchantEntity merchantEntity = new MerchantEntity();
        MerchantDTO merchantDTO = new MerchantDTO();
        when(merchantRepository.findById(id)).thenReturn(Optional.of(merchantEntity));
        when(mapper.toDto(merchantEntity)).thenReturn(merchantDTO);

        MerchantDTO result = merchantService.getMerchantById(id);

        assertEquals(merchantDTO, result);
        verify(merchantRepository, times(1)).findById(id);
        verify(mapper, times(1)).toDto(merchantEntity);
    }

    @Test
    void getMerchantByIdNotFound() {
        Long id = 1L;
        when(merchantRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(InvalidInput.class, () -> merchantService.getMerchantById(id));
        verify(merchantRepository, times(1)).findById(id);
        verifyNoInteractions(mapper);
    }

    @Test
    void getAllMerchants() {
        List<MerchantEntity> merchantEntities = Collections.singletonList(new MerchantEntity());
        List<MerchantDTO> merchantDTOs = Collections.singletonList(new MerchantDTO());
        when(merchantRepository.findAll()).thenReturn(merchantEntities);
        when(mapper.toDtoList(merchantEntities)).thenReturn(merchantDTOs);

        List<MerchantDTO> result = merchantService.getAllMerchants();

        assertEquals(merchantDTOs, result);
        verify(merchantRepository, times(1)).findAll();
        verify(mapper, times(1)).toDtoList(merchantEntities);
    }

    @Test
    void deleteMerchantExisting() {
        Long id = 1L;
        when(merchantRepository.findById(id)).thenReturn(Optional.of(new MerchantEntity()));

        merchantService.deleteMerchant(id);

        verify(merchantRepository, times(1)).findById(id);
        verify(merchantRepository, times(1)).deleteById(id);
    }

    @Test
    void deleteMerchantNotFound() {
        Long id = 1L;
        when(merchantRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(InvalidInput.class, () -> merchantService.deleteMerchant(id));

        verify(merchantRepository, times(1)).findById(id);
        verify(merchantRepository, times(0)).deleteById(id);
    }
    @Test
    void updateMerchantById() {
        Long id = 1L;
        MerchantDTO merchantDTO = new MerchantDTO();
        MerchantEntity merchantEntity = new MerchantEntity();
        when(merchantRepository.findById(id)).thenReturn(Optional.of(merchantEntity));
        when(merchantRepository.save(merchantEntity)).thenReturn(merchantEntity);
        when(mapper.toDto(merchantEntity)).thenReturn(merchantDTO);

        MerchantDTO result = merchantService.updateMerchantById(id, merchantDTO);

        assertEquals(merchantDTO, result);
        verify(merchantRepository, times(1)).findById(id);
        verify(mapper, times(1)).updateFromDto(merchantDTO, merchantEntity);
        verify(merchantRepository, times(1)).save(merchantEntity);
        verify(mapper, times(1)).toDto(merchantEntity);
    }

    @Test
    void updateMerchantByIdNotFound() {
        Long id = 1L;
        MerchantDTO merchantDTO = new MerchantDTO();
        when(merchantRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(InvalidInput.class, () -> merchantService.updateMerchantById(id, merchantDTO));
        verify(merchantRepository, times(1)).findById(id);
        verifyNoMoreInteractions(mapper, merchantRepository);
    }

    @Test
    void findByIban() {
        String iban = "IBAN123";
        MerchantEntity merchantEntity = new MerchantEntity();
        MerchantDTO merchantDTO = new MerchantDTO();
        when(merchantRepository.findByMerchantIban(iban)).thenReturn(Optional.of(merchantEntity));
        when(mapper.toDto(merchantEntity)).thenReturn(merchantDTO);

        MerchantDTO result = merchantService.findByIban(iban);

        assertEquals(merchantDTO, result);
        verify(merchantRepository, times(1)).findByMerchantIban(iban);
        verify(mapper, times(1)).toDto(merchantEntity);
    }

    @Test
    void findByIbanNotFound() {
        String iban = "IBAN123";
        when(merchantRepository.findByMerchantIban(iban)).thenReturn(Optional.empty());

        assertThrows(InvalidInput.class, () -> merchantService.findByIban(iban));
        verify(merchantRepository, times(1)).findByMerchantIban(iban);
        verifyNoInteractions(mapper);
    }

}