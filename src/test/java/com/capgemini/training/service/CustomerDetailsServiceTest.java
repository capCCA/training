package com.capgemini.training.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.capgemini.training.api.service.CustomerDetailsService;
import com.capgemini.training.api.repository.model.CustomerEntity;
import com.capgemini.training.api.repository.CustomerRepository;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class CustomerDetailsServiceTest {
  @Mock private CustomerRepository userRepository;

  @InjectMocks private CustomerDetailsService userService;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  public CustomerEntity createUserEntity(String id) {
    return CustomerEntity.builder()
        .customerId(id)
        .documentType("DNI")
        .documentNumber("123" + id)
        .name("john" + id)
        .surname("green" + id)
        .lastname("junior" + id)
        .country("ESP")
        .telephone(123)
        .build();
  }

  @Test
  @DisplayName("Should return an empty List of customers")
  public void testGetUsers_EmptyList() {
    // Given
    List<CustomerEntity> users = List.of();
    when(userRepository.findAll()).thenReturn(users);

    // When
    List<CustomerEntity> returnedUsers = userService.findAll();

    // Then
    assertNotNull(returnedUsers);
    assertEquals(users.size(), returnedUsers.size());
    assertTrue(returnedUsers.containsAll(users));
    verify(userRepository, times(1)).findAll();
  }

  @Test
  @DisplayName("Should return the List of customers provided (by mock repository) ")
  public void testGetUsers() {
    // Given
    List<CustomerEntity> users = List.of(createUserEntity("2"), createUserEntity("22"));

    when(userRepository.findAll()).thenReturn(users);

    // When
    List<CustomerEntity> returnedUsers = userService.findAll();

    // Then
    assertNotNull(returnedUsers);
    assertEquals(users.size(), returnedUsers.size());
    assertTrue(returnedUsers.containsAll(users));
    verify(userRepository, times(1)).findAll();
  }

  @Test
  @DisplayName("Should get the customer with the Id (by mock repository)")
  public void testGetUserById() {
    // Given
    String userId = "1334";
    CustomerEntity expectedCustomer = createUserEntity("2");
    when(userRepository.findById(userId)).thenReturn(Optional.of(expectedCustomer));

    // When
    Optional<CustomerEntity> returnedCustomer = userService.findById(userId);

    // Then
    assertTrue(returnedCustomer.isPresent());
    assertEquals(expectedCustomer, returnedCustomer.get());
    verify(userRepository, times(1)).findById(userId);
  }
}
