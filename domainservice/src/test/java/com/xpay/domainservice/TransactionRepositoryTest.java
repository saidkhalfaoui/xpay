package com.xpay.domainservice;

import com.xpay.domainservice.entity.MerchantEntity;
import com.xpay.domainservice.entity.TransactionEntity;
import com.xpay.domainservice.entity.UserEntity;
import com.xpay.domainservice.repository.TransactionRepository;
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
public class TransactionRepositoryTest {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private TransactionRepository transactionRepository;

    @Test
    public void testTransactionPersistence() {

        // Create sample User and Merchant entities (assuming they exist)
        UserEntity sender = createSampleUser(); // Implement createSampleUser based on UserEntity
        MerchantEntity receiver = createSampleMerchant(); // Implement createSampleMerchant based on MerchantEntity

        TransactionEntity transaction = new TransactionEntity();
        transaction.setTransactionType("Payment");  // Replace with appropriate transaction types
        transaction.setExternalTransactionId(12345);  // Replace with unique external IDs
        transaction.setSender(sender);
        transaction.setReceiver(receiver);
        transaction.setExecutionDate(LocalDate.now());

        entityManager.persist(transaction);
        entityManager.flush();

        TransactionEntity found = transactionRepository.findById(transaction.getId()).orElse(null);

        assertThat(found).isNotNull();
        assertThat(found.getTransactionType()).isEqualTo("Payment");
        assertThat(found.getExternalTransactionId()).isEqualTo(12345);
        assertThat(found.getSender()).isEqualTo(sender);
        assertThat(found.getReceiver()).isEqualTo(receiver);
        assertThat(found.getExecutionDate()).isEqualTo(LocalDate.now());

        // Test updating a transaction
        transaction.setTransactionType("Refund");
        transactionRepository.save(transaction);

        assertThat(found.getTransactionType()).isEqualTo("Refund");

        // Test deletion
        transactionRepository.delete(transaction);
        assertThat(transactionRepository.existsById(transaction.getId())).isFalse();
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
