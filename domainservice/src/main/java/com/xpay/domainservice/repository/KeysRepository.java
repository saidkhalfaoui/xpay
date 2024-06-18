package com.xpay.domainservice.repository;

import com.xpay.domainservice.entity.KeysEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KeysRepository extends JpaRepository<KeysEntity, Long> {
}
