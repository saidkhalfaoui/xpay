package com.henripay.domainservice.repository;

import com.henripay.domainservice.entity.MandateEntity;
import com.henripay.domainservice.entity.MerchantEntity;
import com.henripay.domainservice.entity.UserEntity;
import org.mapstruct.control.MappingControl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MandateRepository extends JpaRepository<MandateEntity, Long> {
    boolean existsByCustomerAndMerchant(UserEntity user, MerchantEntity merchant);

    MandateEntity findByCustomerAndMerchant(UserEntity customer, MerchantEntity merchant);
}