package com.xpay.domainservice.repository;

import com.xpay.domainservice.entity.MandateEntity;
import com.xpay.domainservice.entity.MerchantEntity;
import com.xpay.domainservice.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MandateRepository extends JpaRepository<MandateEntity, Long> {
    boolean existsByCustomerAndMerchant(UserEntity user, MerchantEntity merchant);

    MandateEntity findByCustomerAndMerchant(UserEntity customer, MerchantEntity merchant);
}
