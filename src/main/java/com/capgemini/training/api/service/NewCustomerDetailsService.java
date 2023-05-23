package com.capgemini.training.api.service;

import static java.time.ZoneOffset.UTC;

import java.time.ZonedDateTime;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.capgemini.training.api.exceptions.CustomerBadRequestException;
import com.capgemini.training.api.model.CustomerDetails;
import com.capgemini.training.api.repository.CustomerRepository;
import com.capgemini.training.api.repository.model.CustomerEntity;
import com.capgemini.training.api.service.mapper.CustomerMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NewCustomerDetailsService {
    private final CustomerRepository userRepository;

    @Transactional
    public CustomerDetails save(CustomerDetails dto) {
        CustomerEntity user = CustomerMapper.toEntity(dto);
        if (userRepository.existsById(user.getCustomerId())) {
            throw new CustomerBadRequestException("Error saving customer. This customerId already exists.");
        }
        user.setCreationDate(ZonedDateTime.now(UTC));
        // get the savedUser
        user = userRepository.save(user);
        return CustomerMapper.toDto(user);
    }
}
