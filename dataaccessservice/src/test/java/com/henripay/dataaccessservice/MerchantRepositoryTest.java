package com.henripay.dataaccessservice;

import com.henripay.dataaccessservice.repository.MerchantRepository;
import com.henripay.domainservice.entity.MerchantEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class MerchantRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private MerchantRepository merchantRepository;

    @Test
    public void whenFindById_thenReturnMerchant() {
        // Given
        MerchantEntity merchant = new MerchantEntity();
        merchant.setMerchantName("Test Merchant");
        merchant.setMerchantAddress("Test Address");
        merchant.setMerchantIban("Test IBAN");

        entityManager.persist(merchant);
        entityManager.flush();

        // When
        MerchantEntity found = merchantRepository.findById(merchant.getMerchantId()).orElse(null);

        // Then
        assertThat(found).isNotNull();
        assertThat(found.getMerchantName()).isEqualTo(merchant.getMerchantName());
    }
}
