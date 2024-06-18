package com.xpay.domainservice;

import com.xpay.domainservice.entity.KeysEntity;
import com.xpay.domainservice.repository.KeysRepository;
import jakarta.persistence.EntityManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
@RunWith(SpringRunner.class)
@DataJpaTest
public class KeysRepositoryTest {
    @Autowired
    private EntityManager entityManager;

    @Autowired
    private KeysRepository keysRepository;

    @Test
    public void test() {

        KeysEntity key = new KeysEntity();
        key.setKeyName("Test Key");
        key.setKeyType("Test Type");
        key.setAdditionalInfo("Test Info");
        key.setEncKeyValue("Test Encrypted Key");

        entityManager.persist(key);
        entityManager.flush();

        KeysEntity found = keysRepository.findById(key.getKeyId()).orElse(null);

        assertThat(found).isNotNull();
        assertThat(found.getKeyName()).isEqualTo(key.getKeyName());

        key.setKeyName("UpdatedName");
        keysRepository.save(key);

        assertThat(found.getKeyName()).isEqualTo(key.getKeyName());

        assertThat(keysRepository.findAll()).size().isEqualTo(1);

        keysRepository.delete(key);
        assertThat(keysRepository.existsById(key.getKeyId())).isFalse();
    }
}
