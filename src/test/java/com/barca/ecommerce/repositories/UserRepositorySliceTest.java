package com.barca.ecommerce.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import com.barca.ecommerce.configs.MongoConfig;
import com.barca.ecommerce.models.Address;
import com.barca.ecommerce.models.User;

// TODO add validation tests

@DataMongoTest
@Import({ MongoConfig.class })
@TestInstance(Lifecycle.PER_CLASS)
@Transactional
@ActiveProfiles("test")
class UserRepositorySliceTest {
  @Autowired
  private UserRepository userRepository;

  @BeforeAll
  void setup() {
    userRepository.deleteAll();
  }

  @Test
  void findByEmail_should_find_document() {

    User user = User.builder()
        .firstName("john")
        .lastName("doe")
        .address(new Address("dummy street name",
            "dummy city", "dummy state", "dummy zip code"))
        .email("johndoe@example.com")
        .password("encryptedpassword")
        .build();
    userRepository.save(user);

    Optional<User> result = userRepository.findByEmail("johndoe@example.com");

    assertThat(result)
        .isPresent()
        .get()
        .hasFieldOrPropertyWithValue("email", "johndoe@example.com");
  }

  @Test
  void findByEmail_should_not_find_document() {

    Optional<User> result = userRepository.findByEmail("johndoe@example.com");

    assertThat(result).isEmpty();
  }
}
