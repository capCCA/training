package com.capgemini.training.services.user;

import com.capgemini.training.models.CustomerDto;
import com.capgemini.training.models.DocumentTypeEnum;
import com.capgemini.training.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

@RequiredArgsConstructor
class EditCustomerServiceTestEntity {

    @Mock
    CustomerRepository customerRepository;
    @InjectMocks

    private final CustomerDto customerDto;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

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
    void edit() {

    }
}