package com.capgemini.training.services.user;

import com.capgemini.training.models.CustomerDto;
import com.capgemini.training.models.DocumentTypeEnum;
import com.capgemini.training.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class DeleteCustomerServiceTestEntity {

    @Mock
    CustomerRepository customerRepository;
    @InjectMocks
    DeleteCustomerService deleteCustomerService;

    private CustomerDto customerDto;

    @BeforeEach
    void setUp() {

        MockitoAnnotations.initMocks(this);
        
        customerDto=
            CustomerDto.builder()
                .customerId("0999")
                .documentType(DocumentTypeEnum.DNI)
                .documentNumber("123456789")
                .name("null")
                .surname("GARCIA")
                .lastname("LOPEZ")
                .country("ESP")
                .telephone(1234567)
                .build();

    }

    @Test
    void delete() {

        //when( customerRepository.deleteById("1") ).thenReturn();
    }
}