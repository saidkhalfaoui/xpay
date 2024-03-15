package com.henripay.domainservice.repository;

import com.henripay.domainservice.entity.AggregatorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AggregatorRepository extends JpaRepository<AggregatorEntity, Long> {
}
