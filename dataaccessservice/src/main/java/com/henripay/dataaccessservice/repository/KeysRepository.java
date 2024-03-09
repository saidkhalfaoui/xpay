package com.henripay.dataaccessservice.repository;

import com.henripay.domainservice.entity.KeysEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KeysRepository extends JpaRepository<KeysEntity, Long> {
}
