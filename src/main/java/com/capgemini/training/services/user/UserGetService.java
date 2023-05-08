package com.capgemini.training.services.user;

import com.capgemini.training.mappers.CustomerMapper;
import com.capgemini.training.models.Customer;
import com.capgemini.training.repository.CustomerRepository;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserGetService {

    //Repository injection
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public ResponseEntity getUserById(String id ){

        if (id != null) {

            Optional<Customer> user = customerRepository.findById(id);

            if( user.isPresent() ){

                return ResponseEntity
                        .ok(customerMapper.customerConverterDto( user.get() ,"Usuario encontrado " + user.get() ));

            }
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("El usuario con ID " + id + " no ha sido encontrado");
        }
        return ResponseEntity
                .internalServerError()
                .body("Fallo al intentar recuperar al usuario en el sistema. Por favor contacte con su administrador ");
    }
    public ResponseEntity getUsers(){

        List<Customer> customers = customerRepository.findAll();

        if( !customers.isEmpty() ){

            //Console´s printing all the customers saved on database.
            customers.
                    stream()
                    .forEach( customer -> System.out.println(customer)
                    );

            return ResponseEntity.ok(customerMapper.customerConverterDto(customers));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hay clientes registrados en la base de datos");
    }
}
