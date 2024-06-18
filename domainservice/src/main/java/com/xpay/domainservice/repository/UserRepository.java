package com.xpay.domainservice.repository;

import com.xpay.domainservice.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByIban(String iban);
    boolean existsUserEntityByIban(String iban);

}
