package com.capgemini.training.api.service;

import static java.time.ZoneOffset.UTC;

import java.time.ZonedDateTime;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.capgemini.training.api.exceptions.CustomerNotFoundException;
import com.capgemini.training.api.model.CustomerDetails;
import com.capgemini.training.api.repository.CustomerRepository;
import com.capgemini.training.api.repository.model.CustomerEntity;
import com.capgemini.training.api.service.mapper.CustomerMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;

@RequiredArgsConstructor
@Log
@Service
public class UpdateCustomerDetailsService {
    private final CustomerRepository userRepository;

    @Transactional
    public CustomerDetails update(String id, CustomerDetails dto) {
//    if( ! userRepository.existsById( id) )
//      throw new CustomerNotFoundException();
//    Optional <CustomerEntity> optUser =  userRepository.findById(id);
//    if (!optUser.isPresent()){
//      throw new CustomerNotFoundException();
//    }
//    CustomerEntity user = optUser.get();

        CustomerEntity user = userRepository.findById(id).orElseThrow(() -> new CustomerNotFoundException());

        ZonedDateTime wasCreated = user.getCreationDate();
        user = CustomerMapper.toEntity(dto);
        // corregir Date estan null al no existir en DTO
        user.setCreationDate(wasCreated);
        user.setUpdateDate(ZonedDateTime.now(UTC));

        // Aqui se puede hacer un Mapper.toEntity( user,dto)
        // corregir CustomerId - si se hubiera cambiado por estar en el Body y ser
        // distinto
        if (!id.equals(user.getCustomerId())) {
            user.setCustomerId(id);
            log.info("update CustomerId " + id + ": Body contains customerId:" + dto.getCustomerId()
                    + ", which is ignored.You can delete and create a new customer.");
        }

        return CustomerMapper.toDto(userRepository.save(user));
    }
}
