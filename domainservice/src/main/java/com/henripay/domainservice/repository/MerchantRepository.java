package com.henripay.domainservice.repository;
import com.henripay.domainservice.entity.MerchantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface MerchantRepository extends  JpaRepository<MerchantEntity, Long>{
}
