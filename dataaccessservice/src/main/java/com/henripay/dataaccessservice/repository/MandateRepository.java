package com.henripay.dataaccessservice.repository;

import com.henripay.domainservice.entity.MandateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MandateRepository extends JpaRepository<MandateEntity, Long> {
}
