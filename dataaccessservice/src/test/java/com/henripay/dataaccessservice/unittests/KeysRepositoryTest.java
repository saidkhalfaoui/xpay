package com.henripay.dataaccessservice.unittests;

import com.henripay.dataaccessservice.repository.KeysRepository;
import com.henripay.domainservice.entity.KeysEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@TestPropertySource(properties = "spring.liquibase.enabled=false")
@RunWith(SpringRunner.class)
@DataJpaTest
public class KeysRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired(required = true)
    private KeysRepository keysRepository;

    @Test
    public void whenFindById_thenReturnKeys() {
        // Given
        KeysEntity keys = new KeysEntity();
        keys.setKeyName("Test Key");
        keys.setKeyType("Test Type");
        keys.setEncKeyValue("Test Value");

        entityManager.persist(keys);
        entityManager.flush();

        // When
        KeysEntity found = keysRepository.findById(keys.getKeyId()).orElse(null);

        // Then
        assertThat(found).isNotNull();
        assertThat(found.getKeyName()).isEqualTo(keys.getKeyName());
    }
}
