package com.capgemini.training.services.user;

import com.capgemini.training.dto.CustomerDto;
import com.capgemini.training.mappers.CustomerMapper;
import com.capgemini.training.models.Customer;
import com.capgemini.training.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserSaveService {

    //Repository injection
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public ResponseEntity saveUser( CustomerDto customerDto ){

        //Removing spaces from customerId to save it clean in database
        customerDto.setCustomerId(customerDto.getCustomerId().trim());

        //Checking Customer ID does not exist on database
        if( !customerRepository.findById( customerDto.getCustomerId() ).isPresent() ){

            customerDto.setCreationDate(new Date());
            Optional<Customer> customer  = Optional.of(customerRepository.save(customerMapper.requestConvertEntity(customerDto)));

            if ( customer.isPresent() ) {

              return ResponseEntity.ok()
                  .body(
                      customerMapper.customerConverterDto(
                          customer.get(), "El usuario " + customer.get() + " ha sido insertado correctamente"));
            }
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Fallo al intentar insertar el usuario " + customer);


        }return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("El ID insertado ya se encuentra registrado en la base de datos");
    }
}
