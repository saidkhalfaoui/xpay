package com.xpay.domainservice.repository;

import com.xpay.domainservice.entity.MetadataEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetadataRepository extends JpaRepository<MetadataEntity, Long> {
}
