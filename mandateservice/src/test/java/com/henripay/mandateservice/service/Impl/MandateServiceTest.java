package com.henripay.mandateservice.service.Impl;
import com.henripay.domainservice.entity.MandateEntity;
import com.henripay.domainservice.entity.MerchantEntity;
import com.henripay.domainservice.entity.UserEntity;
import com.henripay.domainservice.repository.MandateRepository;
import com.henripay.domainservice.repository.MerchantRepository;
import com.henripay.domainservice.repository.UserRepository;
import com.henripay.mandateservice.dto.MandateDTO;
import com.henripay.mandateservice.mapper.MandateMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.NotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MandateServiceTest {
    @Mock
    private MandateRepository mandateRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private MerchantRepository merchantRepository;

    @Mock
    private MandateMapper mandateMapper;

    private MandateService mandateService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mandateService = new MandateService(mandateRepository, merchantRepository, userRepository, mandateMapper);
    }

    @Test
    void testSaveMandateSuccess() {
        // Arrange
        MandateDTO mandateDTO = new MandateDTO();
        mandateDTO.setCustomer(1L);
        mandateDTO.setMerchant(2L);

        UserEntity customer = UserEntity.builder().customerIdIdentifier(1L).build();
        MerchantEntity merchant = MerchantEntity.builder().merchantId(2L).build();
        MandateEntity mandateEntity = new MandateEntity();

        when(userRepository.existsById(1L)).thenReturn(true);
        when(merchantRepository.existsById(2L)).thenReturn(true);
        when(mandateRepository.existsByCustomerAndMerchant(customer, merchant)).thenReturn(false);
        when(mandateMapper.toEntity(mandateDTO)).thenReturn(mandateEntity);
        when(mandateRepository.save(mandateEntity)).thenReturn(mandateEntity);
        when(mandateMapper.toDto(mandateEntity)).thenReturn(mandateDTO);

        // Act
        MandateDTO result = mandateService.saveMandate(mandateDTO);

        // Assert
        assertNotNull(result);
        verify(mandateRepository, times(1)).save(mandateEntity);
    }

    @Test
    void testSaveMandateExistingMandate() {
        // Arrange
        MandateDTO mandateDTO = new MandateDTO();
        mandateDTO.setCustomer(1L);
        mandateDTO.setMerchant(2L);

        UserEntity customer = UserEntity.builder().customerIdIdentifier(1L).build();
        MerchantEntity merchant = MerchantEntity.builder().merchantId(2L).build();
        MandateEntity existingMandate = new MandateEntity();

        when(userRepository.existsById(1L)).thenReturn(true);
        when(merchantRepository.existsById(2L)).thenReturn(true);
        when(mandateRepository.existsByCustomerAndMerchant(customer, merchant)).thenReturn(true);
        when(mandateRepository.findByCustomerAndMerchant(customer, merchant)).thenReturn(existingMandate);
        when(mandateMapper.toDto(existingMandate)).thenReturn(mandateDTO);

        // Act
        MandateDTO result = mandateService.saveMandate(mandateDTO);

        // Assert
        assertNotNull(result);
        assertEquals(mandateDTO, result);
        verify(mandateRepository, never()).save(any(MandateEntity.class));
    }

    @Test
    void testSaveMandateBadRequest() {
        // Arrange
        MandateDTO mandateDTO = new MandateDTO();
        mandateDTO.setCustomer(1L);
        mandateDTO.setMerchant(2L);

        when(userRepository.existsById(1L)).thenReturn(false);
        when(merchantRepository.existsById(2L)).thenReturn(true);

        // Act & Assert
        assertThrows(BadRequestException.class, () -> mandateService.saveMandate(mandateDTO));
    }

    @Test
    void testGetMandateByIdSuccess() {
        // Arrange
        Long id = 1L;
        MandateEntity mandateEntity = new MandateEntity();
        MandateDTO expectedDTO = new MandateDTO();

        when(mandateRepository.findById(id)).thenReturn(Optional.of(mandateEntity));
        when(mandateMapper.toDto(mandateEntity)).thenReturn(expectedDTO);

        // Act
        MandateDTO result = mandateService.getMandateById(id);

        // Assert
        assertEquals(expectedDTO, result);
    }

    @Test
    void testGetMandateByIdNotFound() {
        // Arrange
        Long id = 1L;
        when(mandateRepository.findById(id)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(NotFoundException.class, () -> mandateService.getMandateById(id));
    }

    @Test
    void testGetAllMandates() {
        // Arrange
        List<MandateEntity> mandateEntities = new ArrayList<>();
        mandateEntities.add(new MandateEntity());
        mandateEntities.add(new MandateEntity());

        List<MandateDTO> expectedDTOs = new ArrayList<>();
        expectedDTOs.add(new MandateDTO());
        expectedDTOs.add(new MandateDTO());

        when(mandateRepository.findAll()).thenReturn(mandateEntities);
        when(mandateMapper.toDtoList(mandateEntities)).thenReturn(expectedDTOs);

        // Act
        List<MandateDTO> result = mandateService.getAllMandates();

        // Assert
        assertEquals(expectedDTOs, result);
    }

    @Test
    void testDeleteMandate() {
        // Arrange
        Long id = 1L;

        // Act
        mandateService.deleteMandate(id);

        // Assert
        verify(mandateRepository, times(1)).deleteById(id);
    }

    @Test
    void testUpdateMandateByIdSuccess() {
        // Arrange
        Long id = 1L;
        MandateDTO mandateDTO = new MandateDTO();
        mandateDTO.setCustomer(1L);
        mandateDTO.setMerchant(2L);

        MandateEntity existingMandate = new MandateEntity();

        when(userRepository.existsById(1L)).thenReturn(true);
        when(merchantRepository.existsById(2L)).thenReturn(true);
        when(mandateRepository.findById(id)).thenReturn(Optional.of(existingMandate));
        when(mandateRepository.save(existingMandate)).thenReturn(existingMandate);
        when(mandateMapper.toDto(existingMandate)).thenReturn(mandateDTO);

        // Act
        MandateDTO result = mandateService.updateMandateById(id, mandateDTO);

        // Assert
        assertNotNull(result);
        assertEquals(mandateDTO, result);
        verify(mandateMapper, times(1)).updateFromDto(mandateDTO, existingMandate);
        verify(mandateRepository, times(1)).save(existingMandate);
    }

    @Test
    void testUpdateMandateByIdBadRequest() {
        // Arrange
        Long id = 1L;
        MandateDTO mandateDTO = new MandateDTO();
        mandateDTO.setCustomer(1L);
        mandateDTO.setMerchant(2L);

        when(userRepository.existsById(1L)).thenReturn(false);
        when(merchantRepository.existsById(2L)).thenReturn(true);

        // Act & Assert
        assertThrows(BadRequestException.class, () -> mandateService.updateMandateById(id, mandateDTO));
    }

    @Test
    void testUpdateMandateByIdNotFound() {
        // Arrange
        Long id = 1L;
        MandateDTO mandateDTO = new MandateDTO();
        mandateDTO.setCustomer(1L);
        mandateDTO.setMerchant(2L);

        when(userRepository.existsById(1L)).thenReturn(true);
        when(merchantRepository.existsById(2L)).thenReturn(true);
        when(mandateRepository.findById(id)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(BadRequestException.class, () -> mandateService.updateMandateById(id, mandateDTO));
    }
}