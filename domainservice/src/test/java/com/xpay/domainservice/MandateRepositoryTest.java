package com.xpay.domainservice;

import com.xpay.domainservice.entity.MandateEntity;
import com.xpay.domainservice.entity.MerchantEntity;
import com.xpay.domainservice.entity.UserEntity;
import com.xpay.domainservice.repository.MandateRepository;
import jakarta.persistence.EntityManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class MandateRepositoryTest {
    @Autowired
    private EntityManager entityManager;

    @Autowired
    private MandateRepository mandateRepository;

    @Test
    public void test() {

        // Assuming you have UserEntity and MerchantEntity instances available
        UserEntity customer = createSampleUser();
        MerchantEntity merchant = createSampleMerchant();

        MandateEntity mandate = new MandateEntity();
        mandate.setCustomer(customer);
        mandate.setMerchant(merchant);
        mandate.setSignatureDate(LocalDate.now());
        mandate.setStartDate(LocalDate.now());
        mandate.setEndDate(LocalDate.now().plusMonths(1)); // Example endDate

        entityManager.persist(mandate);
        entityManager.flush();

        MandateEntity found = mandateRepository.findById(mandate.getMandateIdentifier()).orElse(null);

        assertThat(found).isNotNull();
        assertThat(found.getCustomer()).isEqualTo(customer);

        mandate.setEndDate(LocalDate.now().plusMonths(2)); // Update endDate
        mandateRepository.save(mandate);

        assertThat(found.getEndDate()).isEqualTo(mandate.getEndDate());

        assertThat(mandateRepository.findAll()).size().isEqualTo(1);

        mandateRepository.delete(mandate);
        assertThat(mandateRepository.existsById(mandate.getMandateIdentifier())).isFalse();
    }

    public UserEntity createSampleUser() {
        UserEntity user = new UserEntity();
        user.setIban("Test IBAN");
        user.setFullName("Test User Name");
        user.setToken("unique_token"); // Assuming a unique token generation mechanism
        entityManager.persist(user);
        entityManager.flush();
        return user;
    }

    public MerchantEntity createSampleMerchant() {
        MerchantEntity merchant = new MerchantEntity();
        merchant.setMerchantName("Test Merchant Name");
        merchant.setMerchantAddress("Test Merchant Address");
        merchant.setMerchantIban("Test Merchant IBAN");
        merchant.setMerchantCode("unique_merchant_code");
        entityManager.persist(merchant);
        entityManager.flush();
        return merchant;
    }
}
