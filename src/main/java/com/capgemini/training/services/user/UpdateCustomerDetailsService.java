package com.capgemini.training.services.user;

import com.capgemini.training.mappers.CustomerMapper;
import com.capgemini.training.repository.models.CustomerEntity;
import com.capgemini.training.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EditCustomerService {

    //Repository injection
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public ResponseEntity editUser( CustomerEntity customerEntity){



        if( customerRepository.findById( customerEntity.getCustomerId() ).isPresent() ){

            Optional<CustomerEntity> customer1 = Optional.of(customerRepository.save(customerEntity));

            //If customer has been saved correctly
            if( customer1.isPresent() ){

                return ResponseEntity
                        .ok( customerMapper.customerConverterDto(customerEntity, "El usuario: " + customerEntity + " ha sido actualizado correctamente "));

            }
            return ResponseEntity
                    .internalServerError()
                    .body("Fallo al intentar guardar al usuario en el sistema. Por favor contacte con su administrador ");
        }
        return ResponseEntity
                .badRequest()
                .body( customerMapper.customerConverterDto(customerEntity," El usuario con ID " + customerEntity.getCustomerId() + " no existe y no ha podido ser modificado"));

    }
}
