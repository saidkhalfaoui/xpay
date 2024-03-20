package com.henripay.domainservice.repository;

import com.henripay.domainservice.entity.MerchantEntity;
import com.henripay.domainservice.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByIban(String iban);
    boolean existsUserEntityByIban(String iban);

}
