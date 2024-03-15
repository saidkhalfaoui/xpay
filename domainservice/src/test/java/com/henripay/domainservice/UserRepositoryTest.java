package com.henripay.domainservice;

import com.henripay.domainservice.entity.UserEntity;
import com.henripay.domainservice.repository.UserRepository;
import jakarta.persistence.EntityManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testUserPersistence() {

        UserEntity user = new UserEntity();
        user.setIban("DE89370400440532013000"); // Replace with valid IBAN
        user.setFullName("John Doe");
        user.setToken("unique_user_token"); // Ensure uniqueness
        user.setAddress("123 Main St, Anytown");
        user.setActivationDate(LocalDateTime.now());

        entityManager.persist(user);
        entityManager.flush();

        UserEntity found = userRepository.findById(user.getCustomerIdIdentifier()).orElse(null);

        assertThat(found).isNotNull();
        assertThat(found.getIban()).isEqualTo("DE89370400440532013000");
        assertThat(found.getFullName()).isEqualTo("John Doe");
        assertThat(found.getToken()).isEqualTo("unique_user_token");
        assertThat(found.getAddress()).isEqualTo("123 Main St, Anytown");
        assertThat(found.getActivationDate()).isEqualTo(LocalDateTime.now());

        // Test updating user information
        user.setAddress("456 Elm St, New City");
        userRepository.save(user);

        assertThat(found.getAddress()).isEqualTo("456 Elm St, New City");

        // Test deletion
        userRepository.delete(user);
        assertThat(userRepository.existsById(user.getCustomerIdIdentifier())).isFalse();
    }
}
