package com.capgemini.training.service;

import static java.time.ZoneOffset.UTC;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.ZonedDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.capgemini.training.api.exceptions.CustomerBadRequestException;
import com.capgemini.training.api.model.CustomerDetails;
import com.capgemini.training.api.repository.CustomerRepository;
import com.capgemini.training.api.repository.model.CustomerEntity;
import com.capgemini.training.api.service.NewCustomerDetailsService;
import com.capgemini.training.api.service.mapper.CustomerMapper;

public class NewCustomerDetailsServiceTest {

    @Mock
    private CustomerRepository userRepository;

    @InjectMocks
    private NewCustomerDetailsService customerService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    public CustomerDetails createUserDetails(String id) {
        return CustomerDetails.builder().customerId(id).documentType("DNI").documentNumber("123" + id).name("john" + id)
                .surname("green" + id).lastname("junior" + id).country("ESP").telephone(123).build();
    }

    @Test
    @DisplayName("Should create customer ")
    public void testSave_ValidCustomerDetails_ReturnsSavedCustomerDetails() {
        // Mock data
        CustomerDetails customerDetails = createUserDetails("33");
        CustomerEntity customerEntity = CustomerMapper.toEntity(customerDetails);
        customerEntity.setCreationDate(ZonedDateTime.now(UTC));

        // Mock UserRepository behavior
        when(userRepository.existsById(anyString())).thenReturn(false);
        when(userRepository.save(any(CustomerEntity.class))).thenReturn(customerEntity);

        // Invoke the service method
        CustomerDetails savedCustomerDetails = customerService.save(customerDetails);

        // Verify the interactions and assertions
        assertNotNull(savedCustomerDetails);
        assertEquals(customerDetails, savedCustomerDetails);

        verify(userRepository).existsById(anyString());
        verify(userRepository).save(any(CustomerEntity.class));
    }
    // if
    // (userRepository.existsById(user.getCustomerId()))->CustomerBadRequestException
    // returns userDetail = userRepository.save(user);

    @Test
    @DisplayName("Should throw CustomerBadRequestException ")
    public void testSave_DuplicateCustomerId_ThrowsCustomerBadRequestException() {
        // Mock data
        CustomerDetails customerDetails = createUserDetails("33");
        CustomerEntity customerEntity = CustomerMapper.toEntity(customerDetails);
        customerEntity.setCreationDate(ZonedDateTime.now(UTC));

        // Mock UserRepository behavior
        when(userRepository.existsById(anyString())).thenReturn(true);

        // Invoke the service method and assert the exception
        assertThrows(CustomerBadRequestException.class, () -> customerService.save(customerDetails));

        verify(userRepository).existsById(anyString());
        verify(userRepository, never()).save(any(CustomerEntity.class));
    }
    // service.save
    // if (userRepository.existsById(user.getCustomerId()))
    // throw new CustomerBadRequestException
}
