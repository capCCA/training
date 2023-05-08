package com.capgemini.training.services.user;

import com.capgemini.training.mappers.CustomerMapper;
import com.capgemini.training.models.Customer;
import com.capgemini.training.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserEditService {

    //Repository injection
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public ResponseEntity editUser( Customer customer ){



        if( customerRepository.findById( customer.getCustomerId() ).isPresent() ){

            //If customer has been saved correctly
            if( customerRepository.save(customer) != null){

                return ResponseEntity
                        .ok( customerMapper.customerConverterDto( customer, "El usuario: " + customer + " ha sido actualizado correctamente "));

            }
            return ResponseEntity
                    .internalServerError()
                    .body("Fallo al intentar guardar al usuario en el sistema. Por favor contacte con su administrador ");
        }
        return ResponseEntity
                .badRequest()
                .body( customerMapper.customerConverterDto(customer," El usuario con ID " + customer.getCustomerId() + " no existe y no ha podido ser modificado"));

    }
}
