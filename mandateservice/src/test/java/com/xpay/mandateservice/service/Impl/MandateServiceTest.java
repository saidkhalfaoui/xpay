package com.xpay.mandateservice.service.Impl;
import com.xpay.domainservice.entity.MandateEntity;
import com.xpay.domainservice.entity.MerchantEntity;
import com.xpay.domainservice.entity.UserEntity;
import com.xpay.common.exception.InvalidInput;
import com.xpay.domainservice.repository.MandateRepository;
import com.xpay.domainservice.repository.MerchantRepository;
import com.xpay.domainservice.repository.UserRepository;
import com.xpay.mandateservice.dto.MandateDTO;
import com.xpay.mandateservice.mapper.MandateMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.ClassRule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.system.OutputCaptureExtension;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import javax.ws.rs.BadRequestException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import org.springframework.test.context.ActiveProfiles;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(OutputCaptureExtension.class)
@Testcontainers
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@Slf4j
@Transactional
class MandateServiceTest {


    @Container
    @ServiceConnection
    public static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:16.0-alpine");

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
        try (Connection connection = DriverManager.getConnection(
                postgres.getJdbcUrl(),
                postgres.getUsername(),
                postgres.getPassword())) {
            assertThat(connection).isNotNull();
            assertThat(connection.isValid(5)).isTrue(); // Check connection validity
            log.info("Database is ok");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        MockitoAnnotations.openMocks(this);
        mandateService = new MandateService(mandateRepository, merchantRepository, userRepository, mandateMapper);
    }

    @Test
    void contextLoads() {
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
        assertThrows(InvalidInput.class, () -> mandateService.saveMandate(mandateDTO));
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
        assertThrows(InvalidInput.class, () -> mandateService.getMandateById(id));
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

    //todo: fix this test
//    @Test
//    void testDeleteMandate() {
//         Arrange
//        Long id = 1L;
//
//         Act
//        mandateService.deleteMandate(id);
//
//         Assert
//        verify(mandateRepository, times(1)).deleteById(id);
//    }

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
        assertThrows(InvalidInput.class, () -> mandateService.updateMandateById(id, mandateDTO));
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
        assertThrows(InvalidInput.class, () -> mandateService.updateMandateById(id, mandateDTO));
    }
}
