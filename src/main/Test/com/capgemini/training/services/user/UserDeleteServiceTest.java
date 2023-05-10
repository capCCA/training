package com.capgemini.training.services.user;

import com.capgemini.training.dto.CustomerDto;
import com.capgemini.training.dto.DocumentTypeEnum;
import com.capgemini.training.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class UserDeleteServiceTest {

    @Mock
    CustomerRepository customerRepository;
    @InjectMocks
    UserDeleteService userDeleteService;

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

        customerDto = new CustomerDto("1", DocumentTypeEnum.DNI,"25725563V","Albert","GomuGomu","Espina","España",628749583,LocalDate.now(),LocalDate.MIN,"hola");
    }

    @Test
    void delete() {

        when( customerRepository.deleteById("1") ).thenReturn();
    }
}