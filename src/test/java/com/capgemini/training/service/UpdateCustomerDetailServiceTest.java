package com.capgemini.training.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.capgemini.training.api.exceptions.CustomerNotFoundException;
import com.capgemini.training.api.model.CustomerDetails;
import com.capgemini.training.api.repository.CustomerRepository;
import com.capgemini.training.api.repository.model.CustomerEntity;
import com.capgemini.training.api.service.UpdateCustomerDetailsService;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class UpdateCustomerDetailServiceTest {

  @Mock private CustomerRepository userRepository;
  // private CustomerMapper mapper;

  @InjectMocks private UpdateCustomerDetailsService customerService;

  @BeforeEach
  void setUp() {
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

  // Fails: java.lang.NullPointerException: Cannot invoke
  // "com.capgemini.training.entity.CustomerEntity.getCustomerId()" because "user"
  // is null
  // at com.capgemini.training.config.CustomerMapper.toDto(CustomerMapper.java:26)
  // at
  // com.capgemini.training.service.UpdateCustomerDetailsService.update(UpdateCustomerDetailsService.java:44)
  // at
  // com.capgemini.training.service.UpdateCustomerDetailServiceTest.updateExistingCustomer(UpdateCustomerDetailServiceTest.java:61)

  @Test
  @DisplayName("F-------Should update existing customer ")
  void updateExistingCustomer() {
    String customerId = "999999";
    CustomerDetails expectedCustomerDetails = new CustomerDetails();
    expectedCustomerDetails.setCustomerId(customerId);

    CustomerEntity existingCustomer = createUserEntity(customerId);
    // See update we use:
    // CustomerEntity user = userRepository.findById(id).orElse(null);
    // userRepository.save(user)

    when(userRepository.findById(customerId)).thenReturn(Optional.of(existingCustomer));
    when(userRepository.save(existingCustomer)).thenReturn(existingCustomer);
    
    CustomerDetails actualCustomerDetails = customerService.update(customerId, expectedCustomerDetails);

    assertNotNull(actualCustomerDetails);
    assertEquals(expectedCustomerDetails, actualCustomerDetails);

    verify(userRepository).findById(customerId);
    verify(userRepository).save(existingCustomer);
  }

  @Test
  @DisplayName("Should throw CustomerNotFoundException ")
  void updateNonExistingCustomer() {
    String customerId = "12345";
    CustomerDetails customerDetails = new CustomerDetails();
    customerDetails.setCustomerId(customerId);

    // See update
    // CustomerEntity user = userRepository.findById(id).orElse(null);
    // throw new CustomerNotFoundException();

    when(userRepository.findById(customerId)).thenReturn(Optional.empty());

    assertThrows(
        CustomerNotFoundException.class, () -> customerService.update(customerId, customerDetails));

    verify(userRepository).findById(customerId);
    verify(userRepository, never()).save(any());
  }
}
