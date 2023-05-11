package com.capgemini.training.repositories;

import static org.junit.jupiter.api.Assertions.*;

import com.capgemini.training.repositories.models.CustomerEntity;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.TestPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@DataJpaTest
@TestPropertySource(properties = {"spring.jpa.hibernate.ddl-auto=create-drop"})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CustomerRepositoryTestContainer {

  @Autowired private CustomerRepository repository;

  @Container
  private static final PostgreSQLContainer<?> container =
      new PostgreSQLContainer<>("postgres:13")
          .withDatabaseName("test_db")
          .withUsername("user")
          .withPassword("password");

  @DynamicPropertySource
  static void setProperties(DynamicPropertyRegistry registry) {
    registry.add("spring.datasource.url", container::getJdbcUrl);
    registry.add("spring.datasource.username", container::getUsername);
    registry.add("spring.datasource.password", container::getPassword);
  }

  @Test
  void verifyConnection() {
    assertTrue(container.isRunning());
  }

  @Test
  void shouldReturnCustomerWhenSaveCustomer() {
    CustomerEntity customerEntity =
        CustomerEntity.builder()
            .customerId("0999")
            .documentType("DNI")
            .documentNumber("123456789")
            .name("null")
            .surname("GARCIA")
            .lastname("LOPEZ")
            .country("ESP")
            .telephone(1234567)
            .creationDate(LocalDateTime.now())
            .build();

    repository.save(customerEntity);
    assertEquals(1, repository.findAll().size());
  }

  @Test
  void shouldReturnCustomerWhenCustomerIdExists() {
    CustomerEntity customerEntity =
        CustomerEntity.builder()
            .customerId("0999")
            .documentType("DNI")
            .documentNumber("123456789")
            .name("null")
            .surname("GARCIA")
            .lastname("LOPEZ")
            .country("ESP")
            .telephone(1234567)
            .creationDate(LocalDateTime.now())
            .build();

    repository.save(customerEntity);
    assertTrue(repository.existsById(customerEntity.getCustomerId()));
  }
}
