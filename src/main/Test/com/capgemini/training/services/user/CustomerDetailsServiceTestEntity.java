package com.capgemini.training.services.user;

import com.capgemini.training.models.DocumentTypeEnum;
import com.capgemini.training.repository.CustomerRepository;
import com.capgemini.training.repository.models.CustomerEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class GetCustomerServiceTestEntity {

    @Mock
    private CustomerRepository customerRepository;
    @InjectMocks
    private GetCustomerService getCustomerService;
    private CustomerEntity customerEntity;

    //private CustomerDto customerDto;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        customerEntity = CustomerEntity.builder()
                .customerId("0999")
                .documentType(String.valueOf(DocumentTypeEnum.DNI))
                .documentNumber("123456789")
                .name("null")
                .surname("GARCIA")
                .lastname("LOPEZ")
                .country("ESP")
                .telephone(1234567)
                .build();
    }

    @Test
    void getUserById() {

        when( customerRepository.findById("1L")).thenReturn( Optional.of(customerEntity) );

        assertEquals(ResponseEntity.ok().body(customerEntity), getCustomerService.getUserById("1L") );


    }
}