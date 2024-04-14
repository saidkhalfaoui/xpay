package com.henripay.domainservice.repository;

import com.henripay.domainservice.entity.TransactionEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {
    Optional<TransactionEntity> findByTransactionIdAndNature(String transactionId, String nature);

    List<TransactionEntity> findByNatureAndStatus(String nature, String status, Pageable pageable);
}
